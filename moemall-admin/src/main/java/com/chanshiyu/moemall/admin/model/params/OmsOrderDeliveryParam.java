package com.chanshiyu.moemall.admin.model.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author SHIYU
 * @date 2019/11/19 9:38
 * @description 订单发货参数
 */
@Data
public class OmsOrderDeliveryParam {

    @ApiModelProperty("订单id")
    private Long orderId;
    
    @ApiModelProperty("物流公司")
    private String deliveryCompany;

    @ApiModelProperty("物流单号")
    private String deliverySn;

}
