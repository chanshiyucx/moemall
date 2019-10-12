package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.dto.UmsPermissionNode;
import com.chanshiyu.moemall.mbg.model.UmsPermission;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/12 10:37
 * @description 后台权限Service
 */
public interface UmsPermissionService {

    /**
     * 新增权限
     */
    int create(UmsPermission umsPermission);

    /**
     * 更新权限
     */
    int update(UmsPermission umsPermission);

    /**
     * 批量删除权限
     */
    int delete(Long id);

    /**
     * 获取所有权限
     */
    List<UmsPermission> list();

    /**
     * 以层级结构返回所有权限
     */
    List<UmsPermissionNode> treeList();

}
