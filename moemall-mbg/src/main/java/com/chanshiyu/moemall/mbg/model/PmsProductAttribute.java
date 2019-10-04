package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_product_attribute")
public class PmsProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选
     */
    @Column(name = "select_type")
    private Integer selectType;

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     */
    @Column(name = "input_type")
    private Integer inputType;

    /**
     * 可选值列表，以逗号隔开
     */
    @Column(name = "input_list")
    private String inputList;

    /**
     * 排序字段：最高的可以单独上传图片
     */
    private Integer sort;

    /**
     * 分类筛选样式：1->普通；1->颜色
     */
    @Column(name = "filter_type")
    private Integer filterType;

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    @Column(name = "search_type")
    private Integer searchType;

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     */
    @Column(name = "related_status")
    private Integer relatedStatus;

    /**
     * 是否支持手动新增；0->不支持；1->支持
     */
    @Column(name = "hand_add_status")
    private Integer handAddStatus;

    /**
     * 属性的类型；0->规格；1->参数
     */
    private Integer type;
}