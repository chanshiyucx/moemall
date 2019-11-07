package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.params.UmsAdminParam;
import com.chanshiyu.moemall.admin.model.params.UmsUpdateAdminPasswordParam;
import com.chanshiyu.moemall.admin.model.vo.UmsAdminVO;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import com.chanshiyu.moemall.service.vo.CommonListResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/9 16:48
 * @description 后台用户Service
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 用户注册
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 用户登录
     */
    UmsAdminVO login(String username, String password);

    /**
     * 更新用户
     */
    UmsAdmin update(UmsAdminParam umsAdminParam);

    /**
     * 删除用户
     */
    int delete(Long id);

    /**
     * 获取用户所有权限
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**
     * 分页获取用户列表
     */
    CommonListResult<UmsAdminVO> list(Integer pageNum, Integer pageSize);

    /**
     * 更新密码
     */
    void upatePassword(UmsUpdateAdminPasswordParam umsUpdateAdminPasswordParam);

    /**
     * 刷新 token
     */
    String refreshToken(HttpServletRequest request);

}
