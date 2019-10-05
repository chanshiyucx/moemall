package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("优惠券和产品的关系表")
@Table(name = "`sms_coupon_product_relation`")
public class SmsCouponProductRelation implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`coupon_id`")
    @ApiModelProperty("")
    private Long couponId;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    /**
     * 商品名称
     */
    @Column(name = "`product_name`")
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 商品编码
     */
    @Column(name = "`product_sn`")
    @ApiModelProperty("商品编码")
    private String productSn;

    private static final long serialVersionUID = 1L;
}