package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.service.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SHIYU
 * @date 2019/10/10 19:25
 * @description
 */
@Slf4j
@Api(tags = "TestController", description = "测试管理")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation("测试接口")
    @GetMapping("/msg")
    public CommonResult<String> msg() throws Exception {
        return CommonResult.ok("hello testtttttttttttttttttttttttt!");
    }

}
