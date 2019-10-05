package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("订单表")
@Table(name = "`oms_order`")
public class OmsOrder implements Serializable {
    /**
     * 订单id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("订单id")
    private Long id;

    @Column(name = "`member_id`")
    @ApiModelProperty("")
    private Long memberId;

    @Column(name = "`coupon_id`")
    @ApiModelProperty("")
    private Long couponId;

    /**
     * 订单编号
     */
    @Column(name = "`order_sn`")
    @ApiModelProperty("订单编号")
    private String orderSn;

    /**
     * 提交时间
     */
    @Column(name = "`create_time`")
    @ApiModelProperty("提交时间")
    private Date createTime;

    /**
     * 用户帐号
     */
    @Column(name = "`member_username`")
    @ApiModelProperty("用户帐号")
    private String memberUsername;

    /**
     * 订单总金额
     */
    @Column(name = "`total_amount`")
    @ApiModelProperty("订单总金额")
    private BigDecimal totalAmount;

    /**
     * 应付金额（实际支付金额）
     */
    @Column(name = "`pay_amount`")
    @ApiModelProperty("应付金额（实际支付金额）")
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    @Column(name = "`freight_amount`")
    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;

    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    @Column(name = "`promotion_amount`")
    @ApiModelProperty("促销优化金额（促销价、满减、阶梯价）")
    private BigDecimal promotionAmount;

    /**
     * 积分抵扣金额
     */
    @Column(name = "`integration_amount`")
    @ApiModelProperty("积分抵扣金额")
    private BigDecimal integrationAmount;

    /**
     * 优惠券抵扣金额
     */
    @Column(name = "`coupon_amount`")
    @ApiModelProperty("优惠券抵扣金额")
    private BigDecimal couponAmount;

    /**
     * 管理员后台调整订单使用的折扣金额
     */
    @Column(name = "`discount_amount`")
    @ApiModelProperty("管理员后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;

    /**
     * 支付方式：0->未支付；1->支付宝；2->微信
     */
    @Column(name = "`pay_type`")
    @ApiModelProperty("支付方式：0->未支付；1->支付宝；2->微信")
    private Integer payType;

    /**
     * 订单来源：0->PC订单；1->app订单
     */
    @Column(name = "`source_type`")
    @ApiModelProperty("订单来源：0->PC订单；1->app订单")
    private Integer sourceType;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @Column(name = "`status`")
    @ApiModelProperty("订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;

    /**
     * 订单类型：0->正常订单；1->秒杀订单
     */
    @Column(name = "`order_type`")
    @ApiModelProperty("订单类型：0->正常订单；1->秒杀订单")
    private Integer orderType;

    /**
     * 物流公司(配送方式)
     */
    @Column(name = "`delivery_company`")
    @ApiModelProperty("物流公司(配送方式)")
    private String deliveryCompany;

    /**
     * 物流单号
     */
    @Column(name = "`delivery_sn`")
    @ApiModelProperty("物流单号")
    private String deliverySn;

    /**
     * 自动确认时间（天）
     */
    @Column(name = "`auto_confirm_day`")
    @ApiModelProperty("自动确认时间（天）")
    private Integer autoConfirmDay;

    /**
     * 可以获得的积分
     */
    @Column(name = "`integration`")
    @ApiModelProperty("可以获得的积分")
    private Integer integration;

    /**
     * 可以活动的成长值
     */
    @Column(name = "`growth`")
    @ApiModelProperty("可以活动的成长值")
    private Integer growth;

    /**
     * 活动信息
     */
    @Column(name = "`promotion_info`")
    @ApiModelProperty("活动信息")
    private String promotionInfo;

    /**
     * 发票类型：0->不开发票；1->电子发票；2->纸质发票
     */
    @Column(name = "`bill_type`")
    @ApiModelProperty("发票类型：0->不开发票；1->电子发票；2->纸质发票")
    private Integer billType;

    /**
     * 发票抬头
     */
    @Column(name = "`bill_header`")
    @ApiModelProperty("发票抬头")
    private String billHeader;

    /**
     * 发票内容
     */
    @Column(name = "`bill_content`")
    @ApiModelProperty("发票内容")
    private String billContent;

    /**
     * 收票人电话
     */
    @Column(name = "`bill_receiver_phone`")
    @ApiModelProperty("收票人电话")
    private String billReceiverPhone;

    /**
     * 收票人邮箱
     */
    @Column(name = "`bill_receiver_email`")
    @ApiModelProperty("收票人邮箱")
    private String billReceiverEmail;

    /**
     * 收货人姓名
     */
    @Column(name = "`receiver_name`")
    @ApiModelProperty("收货人姓名")
    private String receiverName;

    /**
     * 收货人电话
     */
    @Column(name = "`receiver_phone`")
    @ApiModelProperty("收货人电话")
    private String receiverPhone;

    /**
     * 收货人邮编
     */
    @Column(name = "`receiver_post_code`")
    @ApiModelProperty("收货人邮编")
    private String receiverPostCode;

    /**
     * 省份/直辖市
     */
    @Column(name = "`receiver_province`")
    @ApiModelProperty("省份/直辖市")
    private String receiverProvince;

    /**
     * 城市
     */
    @Column(name = "`receiver_city`")
    @ApiModelProperty("城市")
    private String receiverCity;

    /**
     * 区
     */
    @Column(name = "`receiver_region`")
    @ApiModelProperty("区")
    private String receiverRegion;

    /**
     * 详细地址
     */
    @Column(name = "`receiver_detail_address`")
    @ApiModelProperty("详细地址")
    private String receiverDetailAddress;

    /**
     * 订单备注
     */
    @Column(name = "`note`")
    @ApiModelProperty("订单备注")
    private String note;

    /**
     * 确认收货状态：0->未确认；1->已确认
     */
    @Column(name = "`confirm_status`")
    @ApiModelProperty("确认收货状态：0->未确认；1->已确认")
    private Integer confirmStatus;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    @Column(name = "`delete_status`")
    @ApiModelProperty("删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    /**
     * 下单时使用的积分
     */
    @Column(name = "`use_integration`")
    @ApiModelProperty("下单时使用的积分")
    private Integer useIntegration;

    /**
     * 支付时间
     */
    @Column(name = "`payment_time`")
    @ApiModelProperty("支付时间")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @Column(name = "`delivery_time`")
    @ApiModelProperty("发货时间")
    private Date deliveryTime;

    /**
     * 确认收货时间
     */
    @Column(name = "`receive_time`")
    @ApiModelProperty("确认收货时间")
    private Date receiveTime;

    /**
     * 评价时间
     */
    @Column(name = "`comment_time`")
    @ApiModelProperty("评价时间")
    private Date commentTime;

    /**
     * 修改时间
     */
    @Column(name = "`modify_time`")
    @ApiModelProperty("修改时间")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;
}