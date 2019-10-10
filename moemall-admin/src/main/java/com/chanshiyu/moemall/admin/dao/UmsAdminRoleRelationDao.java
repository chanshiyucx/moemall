package com.chanshiyu.moemall.admin.dao;

import com.chanshiyu.moemall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/10 9:04
 * @description 后台用户与角色管理自定义Dao
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

}
