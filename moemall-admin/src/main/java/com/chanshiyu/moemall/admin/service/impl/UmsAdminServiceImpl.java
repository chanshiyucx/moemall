package com.chanshiyu.moemall.admin.service.impl;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.chanshiyu.moemall.admin.dao.UmsAdminDao;
import com.chanshiyu.moemall.admin.dao.UmsAdminRoleRelationDao;
import com.chanshiyu.moemall.admin.model.params.UmsAdminParam;
import com.chanshiyu.moemall.admin.model.vo.UmsAdminVO;
import com.chanshiyu.moemall.admin.security.utils.JwtTokenUtil;
import com.chanshiyu.moemall.admin.service.UmsAdminService;
import com.chanshiyu.moemall.mbg.mapper.UmsAdminLoginLogMapper;
import com.chanshiyu.moemall.mbg.mapper.UmsAdminMapper;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.mbg.model.UmsAdminLoginLog;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import com.chanshiyu.moemall.service.exception.BadRequestException;
import com.chanshiyu.moemall.service.vo.CommonListResult;
import com.chanshiyu.moemall.service.vo.ResultAttributes;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/9 16:49
 * @description 后台用户Service实现类
 */
@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;

    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Autowired
    private UmsAdminDao umsAdminDao;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UmsAdmin getAdminByUsername(String username) {
        Example example = new Example(UmsAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        return umsAdminMapper.selectOneByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        // 查询是否有相同用户名的用户
        Example example = new Example(UmsAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", umsAdmin.getUsername());
        UmsAdmin result = umsAdminMapper.selectOneByExample(example);
        if (result != null) {
            throw new BadRequestException("该用户已存在");
        }
        // 将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UmsAdminVO login(String username, String password) {
        // 密码需要客户端加密后传递
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        // 获取用户详细信息
        UmsAdmin umsAdmin = getAdminByUsername(username);
        UmsAdminVO umsAdminLoginVO = new UmsAdminVO();
        BeanUtils.copyProperties(umsAdmin, umsAdminLoginVO);
        umsAdminLoginVO.setToken(token);
        // 写入登录日志
        insertLoginLog(username);
        return umsAdminLoginVO;
    }

    @Override
    public int delete(Long id) {
        return umsAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsAdminRoleRelationDao.getPermissionList(adminId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommonListResult<UmsAdminVO> list(Integer pageNum, Integer pageSize) {
        Page<UmsAdminVO> page = PageHelper.startPage(pageNum,pageSize).doSelectPage(()-> umsAdminDao.getAdminList());
        ResultAttributes attributes = new ResultAttributes(page.getPageNum(), page.getPageSize(), page.getTotal());
        return new CommonListResult<>(page.getResult(), attributes);
    }

    /**
     * 添加登录记录
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        UserAgent ua = UserAgentUtil.parse(request.getHeader("user-agent"));
        String userAgent = ua.getBrowser().toString() + "/" + ua.getVersion() + ", " + ua.getOs().toString();
        loginLog.setUserAgent(userAgent);
        log.info("loginLog: {}", loginLog);
        loginLogMapper.insert(loginLog);
    }

}
