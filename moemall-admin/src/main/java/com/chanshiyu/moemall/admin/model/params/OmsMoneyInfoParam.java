package com.chanshiyu.moemall.admin.model.params;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author SHIYU
 * @date 2019/11/19 15:39
 * @description 修改订单费用信息参数
 */
@Data
public class OmsMoneyInfoParam {
    private Long orderId;
    private BigDecimal freightAmount;
    private BigDecimal discountAmount;
    private Integer status;
}
