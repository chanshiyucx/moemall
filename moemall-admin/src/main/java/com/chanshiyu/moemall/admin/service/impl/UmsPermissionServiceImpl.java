package com.chanshiyu.moemall.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.chanshiyu.moemall.admin.model.dto.UmsPermissionNode;
import com.chanshiyu.moemall.admin.service.UmsPermissionService;
import com.chanshiyu.moemall.mbg.mapper.UmsPermissionMapper;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SHIYU
 * @date 2019/10/12 10:38
 * @description 后台权限Service实现类
 */
@Slf4j
@Service
public class UmsPermissionServiceImpl implements UmsPermissionService {

    @Autowired
    private UmsPermissionMapper permissionMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(UmsPermission umsPermission) {
        umsPermission.setCreateTime(new Date());
        // 权限值未设置则为 null
        if (StrUtil.isBlank(umsPermission.getValue())) {
            umsPermission.setValue(null);
        }
        return permissionMapper.insert(umsPermission);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(UmsPermission umsPermission) {
        return permissionMapper.updateByPrimaryKey(umsPermission);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(Long id) {
        Example example = new Example(UmsPermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return permissionMapper.deleteByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UmsPermission> list() {
        Example example = new Example(UmsPermission.class);
        return permissionMapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UmsPermissionNode> treeList() {
        List<UmsPermission> permissionList = list();
        return permissionList.stream()
                .filter(permission -> permission.getPid().equals(0L))
                .map(permission -> covert(permission, permissionList))
                .collect(Collectors.toList());
    }

    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用covert
     */
    private UmsPermissionNode covert(UmsPermission permission, List<UmsPermission> permissionList) {
        UmsPermissionNode node = new UmsPermissionNode();
        BeanUtils.copyProperties(permission, node);
        List<UmsPermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(permission.getId()))
                .map(subPermission -> covert(subPermission, permissionList))
                .collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

}
