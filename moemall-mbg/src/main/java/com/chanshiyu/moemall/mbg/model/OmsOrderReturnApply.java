package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "oms_order_return_apply")
public class OmsOrderReturnApply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 收货地址表id
     */
    @Column(name = "company_address_id")
    private Long companyAddressId;

    /**
     * 退货商品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 订单编号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 申请时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 会员用户名
     */
    @Column(name = "member_username")
    private String memberUsername;

    /**
     * 退款金额
     */
    @Column(name = "return_amount")
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     */
    @Column(name = "return_name")
    private String returnName;

    /**
     * 退货人电话
     */
    @Column(name = "return_phone")
    private String returnPhone;

    /**
     * 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     */
    private Integer status;

    /**
     * 处理时间
     */
    @Column(name = "handle_time")
    private Date handleTime;

    /**
     * 商品图片
     */
    @Column(name = "product_pic")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品品牌
     */
    @Column(name = "product_brand")
    private String productBrand;

    /**
     * 商品销售属性：颜色：红色；尺码：xl;
     */
    @Column(name = "product_attr")
    private String productAttr;

    /**
     * 退货数量
     */
    @Column(name = "product_count")
    private Integer productCount;

    /**
     * 商品单价
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 商品实际支付单价
     */
    @Column(name = "product_real_price")
    private BigDecimal productRealPrice;

    /**
     * 原因
     */
    private String reason;

    /**
     * 描述
     */
    private String description;

    /**
     * 凭证图片，以逗号隔开
     */
    @Column(name = "proof_pics")
    private String proofPics;

    /**
     * 处理备注
     */
    @Column(name = "handle_note")
    private String handleNote;

    /**
     * 处理人员
     */
    @Column(name = "handle_man")
    private String handleMan;

    /**
     * 收货人
     */
    @Column(name = "receive_man")
    private String receiveMan;

    /**
     * 收货时间
     */
    @Column(name = "receive_time")
    private Date receiveTime;

    /**
     * 收货备注
     */
    @Column(name = "receive_note")
    private String receiveNote;

    private static final long serialVersionUID = 1L;
}