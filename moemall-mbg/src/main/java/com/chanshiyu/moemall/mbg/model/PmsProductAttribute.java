package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("商品属性参数表")
@Table(name = "pms_product_attribute")
public class PmsProductAttribute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "product_attribute_category_id")
    @ApiModelProperty("")
    private Long productAttributeCategoryId;

    @ApiModelProperty("")
    private String name;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选
     */
    @Column(name = "select_type")
    @ApiModelProperty("属性选择类型：0->唯一；1->单选；2->多选")
    private Integer selectType;

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     */
    @Column(name = "input_type")
    @ApiModelProperty("属性录入方式：0->手工录入；1->从列表中选取")
    private Integer inputType;

    /**
     * 可选值列表，以逗号隔开
     */
    @Column(name = "input_list")
    @ApiModelProperty("可选值列表，以逗号隔开")
    private String inputList;

    /**
     * 排序字段：最高的可以单独上传图片
     */
    @ApiModelProperty("排序字段：最高的可以单独上传图片")
    private Integer sort;

    /**
     * 分类筛选样式：1->普通；1->颜色
     */
    @Column(name = "filter_type")
    @ApiModelProperty("分类筛选样式：1->普通；1->颜色")
    private Integer filterType;

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    @Column(name = "search_type")
    @ApiModelProperty("检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
    private Integer searchType;

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     */
    @Column(name = "related_status")
    @ApiModelProperty("相同属性产品是否关联；0->不关联；1->关联")
    private Integer relatedStatus;

    /**
     * 是否支持手动新增；0->不支持；1->支持
     */
    @Column(name = "hand_add_status")
    @ApiModelProperty("是否支持手动新增；0->不支持；1->支持")
    private Integer handAddStatus;

    /**
     * 属性的类型；0->规格；1->参数
     */
    @ApiModelProperty("属性的类型；0->规格；1->参数")
    private Integer type;

    private static final long serialVersionUID = 1L;
}