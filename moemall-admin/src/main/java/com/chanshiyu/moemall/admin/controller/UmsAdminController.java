package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.model.params.UmsAdminLoginParam;
import com.chanshiyu.moemall.admin.model.params.UmsAdminParam;
import com.chanshiyu.moemall.admin.model.vo.UmsAdminVO;
import com.chanshiyu.moemall.admin.service.UmsAdminService;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.service.vo.CommonListResult;
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
 * @date 2019/10/12 10:33
 * @description 后台用户管理
 */
@Slf4j
@Api(value = "后台用户管理", tags = "UmsAdminController")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation(value = "测试接口")
    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ums:admin:create')")
    public CommonResult<String> test() {
        return CommonResult.ok("Hello test 111111");
    }

    @ApiOperation(value = "测试接口2")
    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('ums:admin:test2')")
    public CommonResult<String> test2() {
        return CommonResult.ok("Hello test 2222");
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    @PreAuthorize("hasAuthority('ums:admin:create')")
    public CommonResult<UmsAdmin> register(@Valid @RequestBody UmsAdminParam umsAdminParam) {
        return CommonResult.ok(umsAdminService.register(umsAdminParam));
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ums:admin:update')")
    public CommonResult<UmsAdmin> update(@Valid @RequestBody UmsAdminParam umsAdminParam) {
        return CommonResult.ok(umsAdminService.update(umsAdminParam));
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public CommonResult<UmsAdminVO> login(@Valid @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        UmsAdminVO umsAdminLoginVO = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        return CommonResult.ok(umsAdminLoginVO);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ums:admin:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = umsAdminService.delete(id);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "用户列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ums:admin:read')")
    public CommonResult<List<UmsAdminVO>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        CommonListResult<UmsAdminVO> result = umsAdminService.list(pageNum, pageSize);
        return CommonResult.ok(result.getList(), result.getAttributes());
    }

}
