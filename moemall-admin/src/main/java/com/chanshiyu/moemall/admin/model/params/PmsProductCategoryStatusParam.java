package com.chanshiyu.moemall.admin.model.params;

import com.chanshiyu.moemall.admin.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author SHIYU
 * @date 2019/10/18 9:26
 * @description 更新分类状态参数
 */
@Data
public class PmsProductCategoryStatusParam {

    @ApiModelProperty(value = "ID", required = true)
    @NotNull(message = "分类ID不能为空")
    private Long id;

    @ApiModelProperty(value = "是否在导航栏显示", required = true)
    @FlagValidator(value = {"0","1"}, message = "导航栏显示状态不正确")
    private Integer navStatus;

    @ApiModelProperty(value = "是否显示", required = true)
    @FlagValidator(value = {"0","1"}, message = "显示状态不正确")
    private Integer showStatus;

}
