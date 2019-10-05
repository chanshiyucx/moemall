package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("积分消费设置")
@Table(name = "`ums_integration_consume_setting`")
public class UmsIntegrationConsumeSetting implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 每一元需要抵扣的积分数量
     */
    @Column(name = "`deduction_per_amount`")
    @ApiModelProperty("每一元需要抵扣的积分数量")
    private Integer deductionPerAmount;

    /**
     * 每笔订单最高抵用百分比
     */
    @Column(name = "`max_percent_per_order`")
    @ApiModelProperty("每笔订单最高抵用百分比")
    private Integer maxPercentPerOrder;

    /**
     * 每次使用积分最小单位100
     */
    @Column(name = "`use_unit`")
    @ApiModelProperty("每次使用积分最小单位100")
    private Integer useUnit;

    /**
     * 是否可以和优惠券同用；0->不可以；1->可以
     */
    @Column(name = "`coupon_status`")
    @ApiModelProperty("是否可以和优惠券同用；0->不可以；1->可以")
    private Integer couponStatus;

    private static final long serialVersionUID = 1L;
}