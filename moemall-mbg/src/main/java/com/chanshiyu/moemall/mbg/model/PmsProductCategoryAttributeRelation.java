package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）")
@Table(name = "pms_product_category_attribute_relation")
public class PmsProductCategoryAttributeRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 商品分类ID
     */
    @Column(name = "product_category_id")
    @ApiModelProperty("商品分类ID")
    private Long productCategoryId;

    /**
     * 商品属性ID
     */
    @Column(name = "product_attribute_id")
    @ApiModelProperty("商品属性ID")
    private Long productAttributeId;

    private static final long serialVersionUID = 1L;
}