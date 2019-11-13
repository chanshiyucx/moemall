package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.model.vo.PmsProductAttributeCategoryVO;
import com.chanshiyu.moemall.admin.service.PmsProductAttributeCategoryService;
import com.chanshiyu.moemall.mbg.model.PmsProductAttributeCategory;
import com.chanshiyu.moemall.service.vo.CommonListResult;
import com.chanshiyu.moemall.service.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/12 16:28
 * @description 商品属性分类管理
 */
@Slf4j
@Api(tags = "商品属性分类管理")
@RestController
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {

    @Autowired
    PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @ApiOperation(value = "新增商品属性分类")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:productAttribute:create')")
    public CommonResult create(@RequestParam String name) {
        int count = pmsProductAttributeCategoryService.create(name);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "更新商品属性分类")
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('pms:productAttribute:update')")
    public CommonResult update(@PathVariable Long id, @RequestParam String name) {
        int count = pmsProductAttributeCategoryService.update(id, name);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除商品属性分类")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('pms:productAttribute:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = pmsProductAttributeCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取商品属性分类列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:productAttribute:read')")
    public CommonResult<List<PmsProductAttributeCategory>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        CommonListResult<PmsProductAttributeCategory> result = pmsProductAttributeCategoryService.list(pageNum, pageSize);
        return CommonResult.ok(result.getList(), result.getAttributes());
    }

    @ApiOperation("获取所有商品属性分类及其下属性")
    @GetMapping("/listWithAttr")
    @PreAuthorize("hasAuthority('pms:productAttribute:read')")
    public CommonResult<List<PmsProductAttributeCategoryVO>> listWithAttr() {
        List<PmsProductAttributeCategoryVO> result = pmsProductAttributeCategoryService.listWithAttr();
        return CommonResult.ok(result);
    }

}
