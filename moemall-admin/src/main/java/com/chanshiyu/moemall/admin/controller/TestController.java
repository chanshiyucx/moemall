package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.service.UmsAdminService;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import com.chanshiyu.moemall.service.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(tags = "TestController", description = "商品品牌管理")
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

    private final UmsAdminService umsAdminService;

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

}
