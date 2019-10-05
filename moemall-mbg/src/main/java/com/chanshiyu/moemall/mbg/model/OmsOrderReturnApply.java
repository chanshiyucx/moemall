package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("订单退货申请")
@Table(name = "oms_order_return_apply")
public class OmsOrderReturnApply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    @ApiModelProperty("订单id")
    private Long orderId;

    /**
     * 收货地址表id
     */
    @Column(name = "company_address_id")
    @ApiModelProperty("收货地址表id")
    private Long companyAddressId;

    /**
     * 退货商品id
     */
    @Column(name = "product_id")
    @ApiModelProperty("退货商品id")
    private Long productId;

    /**
     * 订单编号
     */
    @Column(name = "order_sn")
    @ApiModelProperty("订单编号")
    private String orderSn;

    /**
     * 申请时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("申请时间")
    private Date createTime;

    /**
     * 会员用户名
     */
    @Column(name = "member_username")
    @ApiModelProperty("会员用户名")
    private String memberUsername;

    /**
     * 退款金额
     */
    @Column(name = "return_amount")
    @ApiModelProperty("退款金额")
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     */
    @Column(name = "return_name")
    @ApiModelProperty("退货人姓名")
    private String returnName;

    /**
     * 退货人电话
     */
    @Column(name = "return_phone")
    @ApiModelProperty("退货人电话")
    private String returnPhone;

    /**
     * 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     */
    @ApiModelProperty("申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝")
    private Integer status;

    /**
     * 处理时间
     */
    @Column(name = "handle_time")
    @ApiModelProperty("处理时间")
    private Date handleTime;

    /**
     * 商品图片
     */
    @Column(name = "product_pic")
    @ApiModelProperty("商品图片")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 商品品牌
     */
    @Column(name = "product_brand")
    @ApiModelProperty("商品品牌")
    private String productBrand;

    /**
     * 商品销售属性：颜色：红色；尺码：xl;
     */
    @Column(name = "product_attr")
    @ApiModelProperty("商品销售属性：颜色：红色；尺码：xl;")
    private String productAttr;

    /**
     * 退货数量
     */
    @Column(name = "product_count")
    @ApiModelProperty("退货数量")
    private Integer productCount;

    /**
     * 商品单价
     */
    @Column(name = "product_price")
    @ApiModelProperty("商品单价")
    private BigDecimal productPrice;

    /**
     * 商品实际支付单价
     */
    @Column(name = "product_real_price")
    @ApiModelProperty("商品实际支付单价")
    private BigDecimal productRealPrice;

    /**
     * 原因
     */
    @ApiModelProperty("原因")
    private String reason;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    /**
     * 凭证图片，以逗号隔开
     */
    @Column(name = "proof_pics")
    @ApiModelProperty("凭证图片，以逗号隔开")
    private String proofPics;

    /**
     * 处理备注
     */
    @Column(name = "handle_note")
    @ApiModelProperty("处理备注")
    private String handleNote;

    /**
     * 处理人员
     */
    @Column(name = "handle_man")
    @ApiModelProperty("处理人员")
    private String handleMan;

    /**
     * 收货人
     */
    @Column(name = "receive_man")
    @ApiModelProperty("收货人")
    private String receiveMan;

    /**
     * 收货时间
     */
    @Column(name = "receive_time")
    @ApiModelProperty("收货时间")
    private Date receiveTime;

    /**
     * 收货备注
     */
    @Column(name = "receive_note")
    @ApiModelProperty("收货备注")
    private String receiveNote;

    private static final long serialVersionUID = 1L;
}