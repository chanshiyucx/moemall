package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.params.UmsRoleParam;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/14 9:45
 * @description 后台角色管理Service
 */
public interface UmsRoleService {

    /**
     * 添加角色
     */
    int create(UmsRoleParam umsRoleParam);

    /**
     * 修改角色信息
     */
    int update(UmsRoleParam umsRoleParam);

    /**
     * 删除角色
     */
    int delete(Long id);

    /**
     * 修改指定角色的权限
     */
    int updatePermission(Long roleId, List<Long> permissionIds);

    /**
     * 获取角色列表
     */
    List<UmsRoleParam> list();

}
