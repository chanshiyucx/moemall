package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("会员积分成长规则表")
@Table(name = "`ums_member_rule_setting`")
public class UmsMemberRuleSetting implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 连续签到天数
     */
    @Column(name = "`continue_sign_day`")
    @ApiModelProperty("连续签到天数")
    private Integer continueSignDay;

    /**
     * 连续签到赠送数量
     */
    @Column(name = "`continue_sign_point`")
    @ApiModelProperty("连续签到赠送数量")
    private Integer continueSignPoint;

    /**
     * 每消费多少元获取1个点
     */
    @Column(name = "`consume_per_point`")
    @ApiModelProperty("每消费多少元获取1个点")
    private BigDecimal consumePerPoint;

    /**
     * 最低获取点数的订单金额
     */
    @Column(name = "`low_order_amount`")
    @ApiModelProperty("最低获取点数的订单金额")
    private BigDecimal lowOrderAmount;

    /**
     * 每笔订单最高获取点数
     */
    @Column(name = "`max_point_per_order`")
    @ApiModelProperty("每笔订单最高获取点数")
    private Integer maxPointPerOrder;

    /**
     * 类型：0->积分规则；1->成长值规则
     */
    @Column(name = "`type`")
    @ApiModelProperty("类型：0->积分规则；1->成长值规则")
    private Integer type;

    private static final long serialVersionUID = 1L;
}