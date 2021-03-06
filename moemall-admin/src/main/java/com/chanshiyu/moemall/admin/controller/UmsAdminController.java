package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.model.params.UmsAdminLoginParam;
import com.chanshiyu.moemall.admin.model.params.UmsAdminParam;
import com.chanshiyu.moemall.admin.model.params.UmsUpdateAdminPasswordParam;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/12 10:33
 * @description 后台用户管理
 */
@Slf4j
@Api(tags = "后台用户管理")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    @PreAuthorize("hasAuthority('ums:admin:create')")
    public CommonResult<UmsAdmin> register(@Valid @RequestBody UmsAdminParam umsAdminParam) {
        return CommonResult.ok(umsAdminService.register(umsAdminParam));
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public CommonResult<UmsAdminVO> login(@Valid @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        UmsAdminVO umsAdminLoginVO = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        return CommonResult.ok(umsAdminLoginVO);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ums:admin:update')")
    public CommonResult<UmsAdmin> update(@Valid @RequestBody UmsAdminParam umsAdminParam) {
        return CommonResult.ok(umsAdminService.update(umsAdminParam));
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

    @ApiOperation(value = "更新密码")
    @PutMapping("/updatePassword")
    @PreAuthorize("hasAuthority('ums:admin:update')")
    public CommonResult updatePassword(@Valid @RequestBody UmsUpdateAdminPasswordParam umsUpdateAdminPasswordParam) {
        umsAdminService.upatePassword(umsUpdateAdminPasswordParam);
        return CommonResult.ok();
    }

    @ApiOperation(value = "刷新token")
    @GetMapping("/refreshToken")
    public CommonResult refreshToken(HttpServletRequest request) {
        String refreshToken = umsAdminService.refreshToken(request);
        return CommonResult.ok(refreshToken);
    }

}
