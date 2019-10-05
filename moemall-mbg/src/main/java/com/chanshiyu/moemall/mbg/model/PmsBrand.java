package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("品牌表")
@Table(name = "`pms_brand`")
public class PmsBrand implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`name`")
    @ApiModelProperty("")
    private String name;

    /**
     * 首字母
     */
    @Column(name = "`first_letter`")
    @ApiModelProperty("首字母")
    private String firstLetter;

    @Column(name = "`sort`")
    @ApiModelProperty("")
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @Column(name = "`factory_status`")
    @ApiModelProperty("是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    @Column(name = "`show_status`")
    @ApiModelProperty("")
    private Integer showStatus;

    /**
     * 产品数量
     */
    @Column(name = "`product_count`")
    @ApiModelProperty("产品数量")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @Column(name = "`product_comment_count`")
    @ApiModelProperty("产品评论数量")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    @Column(name = "`logo`")
    @ApiModelProperty("品牌logo")
    private String logo;

    /**
     * 专区大图
     */
    @Column(name = "`big_pic`")
    @ApiModelProperty("专区大图")
    private String bigPic;

    /**
     * 品牌故事
     */
    @Column(name = "`brand_story`")
    @ApiModelProperty("品牌故事")
    private String brandStory;

    private static final long serialVersionUID = 1L;
}