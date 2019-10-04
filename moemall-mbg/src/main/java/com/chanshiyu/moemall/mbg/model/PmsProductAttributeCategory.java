package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_product_attribute_category")
public class PmsProductAttributeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 属性数量
     */
    @Column(name = "attribute_count")
    private Integer attributeCount;

    /**
     * 参数数量
     */
    @Column(name = "param_count")
    private Integer paramCount;
}