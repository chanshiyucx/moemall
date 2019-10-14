package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.dao.UmsRolePermissionRelationDao;
import com.chanshiyu.moemall.admin.model.params.UmsRoleParam;
import com.chanshiyu.moemall.admin.service.UmsRoleService;
import com.chanshiyu.moemall.mbg.mapper.UmsRoleMapper;
import com.chanshiyu.moemall.mbg.model.UmsRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/14 9:47
 * @description 后台角色Service实现类
 */
@Slf4j
@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    private UmsRoleMapper umsRoleMapper;

    @Autowired
    private UmsRolePermissionRelationDao umsRolePermissionRelationDao;

    @Override
    public int create(UmsRoleParam umsRoleParam) {
        return 0;
    }

    @Override
    public int update(UmsRoleParam umsRoleParam) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        return 0;
    }

    @Override
    public List<UmsRoleParam> list() {
//        List<UmsRoleParam> umsRoleParamList = umsRolePermissionRelationDao.getRoleList();
        return umsRolePermissionRelationDao.getRoleList();
    }

}
