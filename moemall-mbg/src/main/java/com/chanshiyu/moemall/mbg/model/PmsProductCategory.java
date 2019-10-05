package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("产品分类")
@Table(name = "pms_product_category")
public class PmsProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 上机分类的编号：0表示一级分类
     */
    @Column(name = "parent_id")
    @ApiModelProperty("上机分类的编号：0表示一级分类")
    private Long parentId;

    @ApiModelProperty("")
    private String name;

    /**
     * 分类级别：0->1级；1->2级
     */
    @ApiModelProperty("分类级别：0->1级；1->2级")
    private Integer level;

    @Column(name = "product_count")
    @ApiModelProperty("")
    private Integer productCount;

    @Column(name = "product_unit")
    @ApiModelProperty("")
    private String productUnit;

    /**
     * 是否显示在导航栏：0->不显示；1->显示
     */
    @Column(name = "nav_status")
    @ApiModelProperty("是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    /**
     * 显示状态：0->不显示；1->显示
     */
    @Column(name = "show_status")
    @ApiModelProperty("显示状态：0->不显示；1->显示")
    private Integer showStatus;

    @ApiModelProperty("")
    private Integer sort;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("")
    private String keywords;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    private static final long serialVersionUID = 1L;
}