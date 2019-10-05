package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms_coupon")
public class SmsCoupon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
     */
    private Integer type;

    private String name;

    /**
     * 使用平台：0->全部；1->移动；2->PC
     */
    private Integer platform;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 每人限领张数
     */
    @Column(name = "per_limit")
    private Integer perLimit;

    /**
     * 使用门槛；0表示无门槛
     */
    @Column(name = "min_point")
    private BigDecimal minPoint;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 使用类型：0->全场通用；1->指定分类；2->指定商品
     */
    @Column(name = "use_type")
    private Integer useType;

    /**
     * 备注
     */
    private String note;

    /**
     * 发行数量
     */
    @Column(name = "publish_count")
    private Integer publishCount;

    /**
     * 已使用数量
     */
    @Column(name = "use_count")
    private Integer useCount;

    /**
     * 领取数量
     */
    @Column(name = "receive_count")
    private Integer receiveCount;

    /**
     * 可以领取的日期
     */
    @Column(name = "enable_time")
    private Date enableTime;

    /**
     * 优惠码
     */
    private String code;

    /**
     * 可领取的会员类型：0->无限时
     */
    @Column(name = "member_level")
    private Integer memberLevel;

    private static final long serialVersionUID = 1L;
}