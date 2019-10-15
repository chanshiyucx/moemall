package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.model.dto.UmsPermissionNode;
import com.chanshiyu.moemall.admin.service.UmsPermissionService;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import com.chanshiyu.moemall.service.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/12 10:33
 * @description 后台用户权限管理
 */
@Slf4j
@Api(value = "后台用户权限管理", tags = "UmsPermissionController")
@RestController
@RequestMapping("/permission")
public class UmsPermissionController {

    @Autowired
    private UmsPermissionService permissionService;

    @ApiOperation("新增权限")
    @PostMapping("/create")
    public CommonResult create(@Valid @RequestBody UmsPermission permission) {
        int count = permissionService.create(permission);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改权限")
    @PutMapping("/update")
    public CommonResult update(@Valid @RequestBody UmsPermission permission) {
        int count = permissionService.update(permission);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除权限")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        int count = permissionService.delete(id);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有权限列表")
    @GetMapping("/list")
    public CommonResult<List<UmsPermission>> list() {
        List<UmsPermission> permissionList = permissionService.list();
        return CommonResult.ok(permissionList);
    }

    @ApiOperation("以层级结构返回所有权限")
    @GetMapping("/treeList")
    public CommonResult<List<UmsPermissionNode>> treeList() {
        List<UmsPermissionNode> permissionNodeList = permissionService.treeList();
        return CommonResult.ok(permissionNodeList);
    }

}
