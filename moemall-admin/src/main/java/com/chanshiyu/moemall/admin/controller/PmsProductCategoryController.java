package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.model.params.PmsProductCategoryParam;
import com.chanshiyu.moemall.admin.model.params.PmsProductCategoryStatusParam;
import com.chanshiyu.moemall.admin.service.PmsProductCategoryService;
import com.chanshiyu.moemall.mbg.model.PmsProductCategory;
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
 * @date 2019/10/18 10:58
 * @description 商品分类管理
 */
@Slf4j
@Api(tags = "商品分类管理")
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    @ApiOperation(value = "新增分类")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:productCategory:create')")
    public CommonResult create(@Valid @RequestBody PmsProductCategoryParam pmsProductCategoryParam) {
        int count = pmsProductCategoryService.create(pmsProductCategoryParam);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "更新分类")
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult update(@Valid @RequestBody PmsProductCategoryParam pmsProductCategoryParam) {
        int count = pmsProductCategoryService.update(pmsProductCategoryParam);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "更新分类状态")
    @PutMapping("/update/status")
    @PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult updateStatus(@Valid @RequestBody PmsProductCategoryStatusParam pmsProductCategoryStatusParam) {
        int count = pmsProductCategoryService.updateStatus(pmsProductCategoryStatusParam);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除分类")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('pms:productCategory:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = pmsProductCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取分类列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:productCategory:read')")
    public CommonResult<List<PmsProductCategory>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                             @RequestParam(value = "parentId", defaultValue = "0") Long parentId) {
        CommonListResult<PmsProductCategory> result = pmsProductCategoryService.list(parentId, pageNum, pageSize);
        return CommonResult.ok(result.getList(), result.getAttributes());
    }

}
