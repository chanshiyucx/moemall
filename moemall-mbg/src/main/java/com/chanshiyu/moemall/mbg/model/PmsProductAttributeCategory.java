package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("产品属性分类表")
@Table(name = "pms_product_attribute_category")
public class PmsProductAttributeCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String name;

    /**
     * 属性数量
     */
    @Column(name = "attribute_count")
    @ApiModelProperty("属性数量")
    private Integer attributeCount;

    /**
     * 参数数量
     */
    @Column(name = "param_count")
    @ApiModelProperty("参数数量")
    private Integer paramCount;

    private static final long serialVersionUID = 1L;
}