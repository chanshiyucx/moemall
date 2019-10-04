package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms_coupon_product_category_relation")
public class SmsCouponProductCategoryRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    /**
     * 产品分类名称
     */
    @Column(name = "product_category_name")
    private String productCategoryName;

    /**
     * 父分类名称
     */
    @Column(name = "parent_category_name")
    private String parentCategoryName;
}