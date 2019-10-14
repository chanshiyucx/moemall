package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.dao.UmsRolePermissionRelationDao;
import com.chanshiyu.moemall.admin.model.params.UmsRoleParam;
import com.chanshiyu.moemall.admin.service.UmsRoleService;
import com.chanshiyu.moemall.mbg.mapper.UmsRoleMapper;
import com.chanshiyu.moemall.mbg.mapper.UmsRolePermissionRelationMapper;
import com.chanshiyu.moemall.mbg.model.UmsRole;
import com.chanshiyu.moemall.mbg.model.UmsRolePermissionRelation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
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
    private UmsRolePermissionRelationMapper umsRolePermissionRelationMapper;

    @Autowired
    private UmsRolePermissionRelationDao umsRolePermissionRelationDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(UmsRoleParam umsRoleParam) {
        UmsRole umsRole = new UmsRole();
        BeanUtils.copyProperties(umsRoleParam, umsRole);
        umsRole.setCreateTime(new Date());
        umsRole.setAdminCount(0);
        umsRoleMapper.insert(umsRole);
        return updatePermission(umsRole.getId(), umsRoleParam.getPermissionIds());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(UmsRoleParam umsRoleParam) {
        UmsRole umsRole = new UmsRole();
        BeanUtils.copyProperties(umsRoleParam, umsRole);
        umsRoleMapper.updateByPrimaryKey(umsRole);
        return updatePermission(umsRole.getId(), umsRoleParam.getPermissionIds());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(Long id) {
        return umsRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UmsRoleParam> list() {
        return umsRolePermissionRelationDao.getRoleList();
    }

    private int updatePermission(Long roleId, List<Long> permissionIds) {
        // 先删除原有关系
        Example example = new Example(UmsRolePermissionRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        umsRolePermissionRelationMapper.deleteByExample(example);
        // 批量插入新关系
        List<UmsRolePermissionRelation> relationList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            UmsRolePermissionRelation relation = new UmsRolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        return umsRolePermissionRelationMapper.insertList(relationList);
    }

}
