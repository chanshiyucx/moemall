package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("优惠券使用、领取历史表")
@Table(name = "sms_coupon_history")
public class SmsCouponHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "coupon_id")
    @ApiModelProperty("")
    private Long couponId;

    @Column(name = "member_id")
    @ApiModelProperty("")
    private Long memberId;

    @Column(name = "coupon_code")
    @ApiModelProperty("")
    private String couponCode;

    /**
     * 领取人昵称
     */
    @Column(name = "member_nickname")
    @ApiModelProperty("领取人昵称")
    private String memberNickname;

    /**
     * 获取类型：0->后台赠送；1->主动获取
     */
    @Column(name = "get_type")
    @ApiModelProperty("获取类型：0->后台赠送；1->主动获取")
    private Integer getType;

    @Column(name = "create_time")
    @ApiModelProperty("")
    private Date createTime;

    /**
     * 使用状态：0->未使用；1->已使用；2->已过期
     */
    @Column(name = "use_status")
    @ApiModelProperty("使用状态：0->未使用；1->已使用；2->已过期")
    private Integer useStatus;

    /**
     * 使用时间
     */
    @Column(name = "use_time")
    @ApiModelProperty("使用时间")
    private Date useTime;

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    @ApiModelProperty("订单编号")
    private Long orderId;

    /**
     * 订单号码
     */
    @Column(name = "order_sn")
    @ApiModelProperty("订单号码")
    private String orderSn;

    private static final long serialVersionUID = 1L;
}