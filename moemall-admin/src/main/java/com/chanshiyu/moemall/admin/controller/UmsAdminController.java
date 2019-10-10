package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.dto.UmsAdminParam;
import com.chanshiyu.moemall.admin.service.UmsAdminService;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import com.chanshiyu.moemall.service.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("测试接口")
    @GetMapping("/msg")
    public CommonResult<String> msg() throws Exception {
        return CommonResult.ok("hello chanshiyu");
    }

    @ApiOperation("测试接口")
    @GetMapping("/user/{username}")
    public CommonResult<UmsAdmin> user(@PathVariable String username) throws Exception {
        log.info("username: {}", username);
        return CommonResult.ok(umsAdminService.getAdminByUsername(username));
    }

    @ApiOperation("测试接口")
        @GetMapping("/permission/{username}")
    public CommonResult<List<UmsPermission>> permission(@PathVariable String username) throws Exception {
        log.info("username: {}", username);
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(username);
        return CommonResult.ok(umsAdminService.getPermissionList(umsAdmin.getId()));
    }

    /** =================================================================== **/

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(@Valid @RequestBody UmsAdminParam umsAdminParam) {
        return CommonResult.ok(umsAdminService.register(umsAdminParam));
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public CommonResult<String> login(@Valid @RequestBody UmsAdminParam umsAdminParam) {
        String token = umsAdminService.login(umsAdminParam.getUsername(), umsAdminParam.getPassword());
        return CommonResult.ok(token);
    }

}
