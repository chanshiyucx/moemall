package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.dto.params.UmsAdminLoginParam;
import com.chanshiyu.moemall.admin.dto.params.UmsAdminParam;
import com.chanshiyu.moemall.admin.dto.vo.UmsAdminLoginVO;
import com.chanshiyu.moemall.admin.service.UmsAdminService;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.service.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("测试接口")
    @GetMapping("/msg")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<String> msg() {
        return CommonResult.ok("hello 1111111111111111111111");
    }

    @ApiOperation("测试接口")
    @GetMapping("/msg2")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<String> msg2() {
        return CommonResult.ok("hello 22222222222222222222222");
    }

    /** =================================================================== **/

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(@Valid @RequestBody UmsAdminParam umsAdminParam) {
        return CommonResult.ok(umsAdminService.register(umsAdminParam));
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public CommonResult<UmsAdminLoginVO> login(@Valid @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        UmsAdminLoginVO umsAdminLoginVO = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        return CommonResult.ok(umsAdminLoginVO);
    }

}
