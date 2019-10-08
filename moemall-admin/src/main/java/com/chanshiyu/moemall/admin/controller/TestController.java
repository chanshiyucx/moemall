package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.service.exception.AuthenticationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "TestController", description = "商品品牌管理")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation("测试接口")
    @GetMapping("/msg")
    public String test() throws Exception {
        throw new AuthenticationException("账户未授权");
//        return "hello chanshiyu";
    }

}
