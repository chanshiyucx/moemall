package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.service.PmsProductAttributeService;
import com.chanshiyu.moemall.mbg.model.PmsProductAttribute;
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
 * @date 2019/11/12 14:50
 * @description 商品属性管理
 */
@Slf4j
@Api(tags = "商品属性管理")
@RestController
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {

    @Autowired
    PmsProductAttributeService pmsProductAttributeService;

    @ApiOperation(value = "新增商品属性")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:productAttribute:create')")
    public CommonResult create(@Valid @RequestBody PmsProductAttribute pmsProductAttribute) {
        int count = pmsProductAttributeService.create(pmsProductAttribute);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "更新商品属性")
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('pms:productAttribute:update')")
    public CommonResult update(@Valid @RequestBody PmsProductAttribute pmsProductAttribute) {
        int count = pmsProductAttributeService.update(pmsProductAttribute);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除商品属性")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('pms:productAttribute:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = pmsProductAttributeService.delete(id);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取商品属性列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:productAttribute:read')")
    public CommonResult<List<PmsProductAttribute>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @RequestParam(value = "cid", required = true) Long cid,
                                                        @RequestParam(value = "type", required = true) Integer type) {
        CommonListResult<PmsProductAttribute> result = pmsProductAttributeService.list(pageNum, pageSize, cid, type);
        return CommonResult.ok(result.getList(), result.getAttributes());
    }

}
