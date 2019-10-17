package com.chanshiyu.moemall.admin.model.params;

import com.chanshiyu.moemall.admin.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author SHIYU
 * @date 2019/10/16 9:03
 * @description 商品品牌参数
 */
@Data
public class PmsBrandParam {

    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("名称")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @ApiModelProperty("首字母")
    private String firstLetter;

    @ApiModelProperty("排序")
    @Min(value = 0, message = "排序最小为0")
    private Integer sort;

    @ApiModelProperty("是否为品牌制造商：0->不是；1->是")
    @FlagValidator(value = {"0","1"}, message = "厂家状态不正确")
    private Integer factoryStatus;

    @ApiModelProperty("是否显示")
    @FlagValidator(value = {"0","1"}, message = "显示状态不正确")
    private Integer showStatus;

    @ApiModelProperty("品牌logo")
    @NotEmpty(message = "品牌logo不能为空")
    private String logo;

    @ApiModelProperty("专区大图")
    private String bigPic;

    @ApiModelProperty("品牌故事")
    private String brandStory;

}
