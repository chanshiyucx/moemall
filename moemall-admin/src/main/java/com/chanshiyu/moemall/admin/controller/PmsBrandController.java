package com.chanshiyu.moemall.admin.controller;

import com.chanshiyu.moemall.admin.model.params.PmsBrandParam;
import com.chanshiyu.moemall.admin.model.params.PmsBrandStatusParam;
import com.chanshiyu.moemall.admin.service.PmsBrandService;
import com.chanshiyu.moemall.mbg.model.PmsBrand;
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
 * @date 2019/10/17 15:11
 * @description 品牌管理
 */
@Slf4j
@Api(value = "品牌管理", tags = "PmsBrandController")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    @ApiOperation(value = "新增品牌")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult create(@Valid @RequestBody PmsBrandParam pmsBrandParam) {
        int count = pmsBrandService.create(pmsBrandParam);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "更新品牌")
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult update(@Valid @RequestBody PmsBrandParam pmsBrandParam) {
        int count = pmsBrandService.update(pmsBrandParam);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "更新品牌状态")
    @PutMapping("/update/status")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult updateStatus(@Valid @RequestBody PmsBrandStatusParam pmsBrandStatusParam) {
        int count = pmsBrandService.updateStatus(pmsBrandStatusParam);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除品牌")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = pmsBrandService.delete(id);
        if (count > 0) {
            return CommonResult.ok();
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取品牌列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                             @RequestParam(value = "name", defaultValue = "") String name) {
        CommonListResult<PmsBrand> result = pmsBrandService.list(pageNum, pageSize, name);
        return CommonResult.ok(result.getList(), result.getAttributes());
    }

}
