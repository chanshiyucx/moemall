package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.model.params.UmsRoleParam;
import com.chanshiyu.moemall.admin.service.UmsRoleService;
import com.chanshiyu.moemall.service.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/14 9:36
 * @description 后台用户角色管理
 */
@Slf4j
@Api(tags = "后台用户角色管理")
@RestController
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation("新增角色")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ums:role:create')")
    public CommonResult create(@Valid @RequestBody UmsRoleParam umsRoleParam) {
        int count = umsRoleService.create(umsRoleParam);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("更新角色")
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ums:role:update')")
    public CommonResult update(@Valid @RequestBody UmsRoleParam umsRoleParam) {
        int count = umsRoleService.update(umsRoleParam);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ums:role:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = umsRoleService.delete(id);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取角色列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ums:role:read')")
    public CommonResult<List<UmsRoleParam>> list() {
        List<UmsRoleParam> roleList = umsRoleService.list();
        return CommonResult.ok(roleList);
    }

}
