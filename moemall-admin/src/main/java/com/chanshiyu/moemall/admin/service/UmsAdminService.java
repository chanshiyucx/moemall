package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.dto.params.UmsAdminParam;
import com.chanshiyu.moemall.admin.dto.vo.UmsAdminLoginVO;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.mbg.model.UmsPermission;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/9 16:48
 * @description 后台管理员Service
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     */
    UmsAdminLoginVO login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);

}
