package com.chanshiyu.moemall.admin.dao;

import com.chanshiyu.moemall.admin.model.params.UmsRoleParam;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/14 9:56
 * @description 后台角色管理自定义Dao
 */
public interface UmsRolePermissionRelationDao {

    /**
     * 获取角色列表
     */
    List<UmsRoleParam> getRoleList();

    /**
     * 根据角色获取权限
     */
    List<UmsPermission> getPermissionList(@Param("roleId") Long roleId);

}
