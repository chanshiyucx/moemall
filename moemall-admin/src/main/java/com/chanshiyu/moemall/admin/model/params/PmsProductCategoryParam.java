package com.chanshiyu.moemall.admin.model.params;

import com.chanshiyu.moemall.admin.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/18 9:03
 * @description 商品分类参数
 */
@Data
public class PmsProductCategoryParam {

    @ApiModelProperty("父分类的编号")
    private Long parentId;

    @ApiModelProperty(value = "商品分类名称", required = true)
    @NotEmpty(message = "商品分类名称不能为空")
    private String name;

    @ApiModelProperty("分类单位")
    private String productUnit;

    @ApiModelProperty(value = "是否在导航栏显示", required = true)
    @FlagValidator(value = {"0","1"}, message = "导航栏显示状态不正确")
    private Integer navStatus;

    @ApiModelProperty(value = "是否进行显示", required = true)
    @FlagValidator(value = {"0","1"}, message = "显示状态不正确")
    private Integer showStatus;

    @ApiModelProperty(value = "排序", required = true)
    @Min(value = 0,message = "排序最小为0")
    private Integer sort;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("关键字")
    private String keywords;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("产品相关筛选属性集合")
    private List<Long> productAttributeIdList;

}
