package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("优惠券和产品分类关系表")
@Table(name = "`sms_coupon_product_category_relation`")
public class SmsCouponProductCategoryRelation implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`coupon_id`")
    @ApiModelProperty("")
    private Long couponId;

    @Column(name = "`product_category_id`")
    @ApiModelProperty("")
    private Long productCategoryId;

    /**
     * 产品分类名称
     */
    @Column(name = "`product_category_name`")
    @ApiModelProperty("产品分类名称")
    private String productCategoryName;

    /**
     * 父分类名称
     */
    @Column(name = "`parent_category_name`")
    @ApiModelProperty("父分类名称")
    private String parentCategoryName;

    private static final long serialVersionUID = 1L;
}