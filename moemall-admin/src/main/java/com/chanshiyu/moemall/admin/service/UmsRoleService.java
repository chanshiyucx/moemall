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
     * 新增角色
     */
    int create(UmsRoleParam umsRoleParam);

    /**
     * 更新角色
     */
    int update(UmsRoleParam umsRoleParam);

    /**
     * 删除角色
     */
    int delete(Long id);

    /**
     * 获取角色列表
     */
    List<UmsRoleParam> list();

}
