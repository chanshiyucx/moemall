package com.chanshiyu.moemall.mbg.model;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "ums_member_rule_setting")
public class UmsMemberRuleSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 连续签到天数
     */
    @Column(name = "continue_sign_day")
    private Integer continueSignDay;

    /**
     * 连续签到赠送数量
     */
    @Column(name = "continue_sign_point")
    private Integer continueSignPoint;

    /**
     * 每消费多少元获取1个点
     */
    @Column(name = "consume_per_point")
    private BigDecimal consumePerPoint;

    /**
     * 最低获取点数的订单金额
     */
    @Column(name = "low_order_amount")
    private BigDecimal lowOrderAmount;

    /**
     * 每笔订单最高获取点数
     */
    @Column(name = "max_point_per_order")
    private Integer maxPointPerOrder;

    /**
     * 类型：0->积分规则；1->成长值规则
     */
    private Integer type;
}