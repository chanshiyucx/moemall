package com.chanshiyu.moemall.admin.service.impl;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.chanshiyu.moemall.admin.dao.UmsAdminDao;
import com.chanshiyu.moemall.admin.dao.UmsAdminRoleRelationDao;
import com.chanshiyu.moemall.admin.model.params.UmsAdminParam;
import com.chanshiyu.moemall.admin.model.params.UmsUpdateAdminPasswordParam;
import com.chanshiyu.moemall.admin.model.vo.UmsAdminVO;
import com.chanshiyu.moemall.admin.security.utils.JwtTokenUtil;
import com.chanshiyu.moemall.admin.service.UmsAdminService;
import com.chanshiyu.moemall.mbg.mapper.UmsAdminLoginLogMapper;
import com.chanshiyu.moemall.mbg.mapper.UmsAdminMapper;
import com.chanshiyu.moemall.mbg.mapper.UmsAdminRoleRelationMapper;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.mbg.model.UmsAdminLoginLog;
import com.chanshiyu.moemall.mbg.model.UmsAdminRoleRelation;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import com.chanshiyu.moemall.service.exception.BadRequestException;
import com.chanshiyu.moemall.service.vo.CommonListResult;
import com.chanshiyu.moemall.service.vo.ResultAttributes;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.micrometer.core.instrument.util.StringUtils;
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
import java.util.stream.Collectors;

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
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

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
        // 更新用户角色关系表
        updateRole(umsAdmin.getId(), umsAdminParam.getRoleIds());
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
        UmsAdminVO umsAdminVO = new UmsAdminVO();
        BeanUtils.copyProperties(umsAdmin, umsAdminVO);
        umsAdminVO.setToken(token);
        List<Long> permissionIds = getPermissionList(umsAdmin.getId()).stream()
                .map(UmsPermission::getId)
                .collect(Collectors.toList());
        umsAdminVO.setPermissionIds(permissionIds);
        // 写入登录日志
        insertLoginLog(username);
        return umsAdminVO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UmsAdmin update(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        // 如果密码不为空
        if (StringUtils.isNotBlank(umsAdmin.getPassword())) {
            String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
            umsAdmin.setPassword(encodePassword);
        }
        umsAdminMapper.updateByPrimaryKeySelective(umsAdmin);
        // 更新用户角色关系表
        updateRole(umsAdmin.getId(), umsAdminParam.getRoleIds());
        return umsAdmin;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
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
        Page<UmsAdminVO> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> umsAdminDao.getAdminList());
        ResultAttributes attributes = new ResultAttributes(page.getPageNum(), page.getPageSize(), page.getTotal());
        return new CommonListResult<>(page.getResult(), attributes);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void upatePassword(UmsUpdateAdminPasswordParam umsUpdateAdminPasswordParam) {
        Example example = new Example(UmsAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", umsUpdateAdminPasswordParam.getUsername());
        UmsAdmin umsAdmin = umsAdminMapper.selectOneByExample(example);
        if (umsAdmin == null) {
            throw new BadRequestException("用户不存在");
        }
        if (!passwordEncoder.matches(umsUpdateAdminPasswordParam.getOldPassword(), umsAdmin.getPassword())) {
            throw new BadRequestException("旧密码错误");
        }
        umsAdmin.setPassword(passwordEncoder.encode(umsUpdateAdminPasswordParam.getNewPassword()));
        umsAdminMapper.updateByPrimaryKeySelective(umsAdmin);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public String refreshToken(HttpServletRequest request) {
        String token = jwtTokenUtil.getToken(request);
        if (jwtTokenUtil.canRefresh(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

    /**
     * 添加登录记录
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
        loginLogMapper.insert(loginLog);
    }

    private void updateRole(Long adminId, List<Long> roleIds) {
        // 先删除原有关系
        Example example = new Example(UmsAdminRoleRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("adminId", adminId);
        umsAdminRoleRelationMapper.deleteByExample(example);
        // 批量插入新关系
        List<UmsAdminRoleRelation> relationList = roleIds.stream()
                .map(roleId -> {
                    UmsAdminRoleRelation relation = new UmsAdminRoleRelation();
                    relation.setAdminId(adminId);
                    relation.setRoleId(roleId);
                    return relation;
                }).collect(Collectors.toList());
        umsAdminRoleRelationMapper.insertList(relationList);
    }

}
