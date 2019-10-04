package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_product_category_attribute_relation")
public class PmsProductCategoryAttributeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "product_attribute_id")
    private Long productAttributeId;
}