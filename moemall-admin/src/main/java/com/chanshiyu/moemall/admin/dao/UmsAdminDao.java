package com.chanshiyu.moemall.admin.dao;

import com.chanshiyu.moemall.admin.model.vo.UmsAdminVO;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/14 15:12
 * @description 后台用户管理自定义Dao
 */
public interface UmsAdminDao {
    
    List<UmsAdminVO> getAdminList();
    
}
