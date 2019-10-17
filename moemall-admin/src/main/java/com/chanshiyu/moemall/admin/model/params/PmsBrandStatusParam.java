package com.chanshiyu.moemall.admin.model.params;

import com.chanshiyu.moemall.admin.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author SHIYU
 * @date 2019/10/17 16:18
 * @description 更新品牌状态参数
 */
@Data
public class PmsBrandStatusParam {

    @ApiModelProperty("ID")
    @NotNull(message = "品牌ID不能为空")
    private Long id;

    @ApiModelProperty("是否为品牌制造商：0->不是；1->是")
    @FlagValidator(value = {"0","1"}, message = "厂家状态不正确")
    private Integer factoryStatus;

    @ApiModelProperty("是否显示")
    @FlagValidator(value = {"0","1"}, message = "显示状态不正确")
    private Integer showStatus;

}
