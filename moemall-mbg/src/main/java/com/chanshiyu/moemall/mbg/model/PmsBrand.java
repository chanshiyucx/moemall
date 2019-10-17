package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("品牌表")
@Table(name = "pms_brand")
public class PmsBrand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 首字母
     */
    @Column(name = "first_letter")
    @ApiModelProperty("首字母")
    private String firstLetter;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @Column(name = "factory_status")
    @ApiModelProperty("是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    /**
     * 是否显示
     */
    @Column(name = "show_status")
    @ApiModelProperty("是否显示")
    private Integer showStatus;

    /**
     * 产品数量
     */
    @Column(name = "product_count")
    @ApiModelProperty("产品数量")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @Column(name = "product_comment_count")
    @ApiModelProperty("产品评论数量")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    @ApiModelProperty("品牌logo")
    private String logo;

    /**
     * 专区大图
     */
    @Column(name = "big_pic")
    @ApiModelProperty("专区大图")
    private String bigPic;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 品牌故事
     */
    @Column(name = "brand_story")
    @ApiModelProperty("品牌故事")
    private String brandStory;

    private static final long serialVersionUID = 1L;
}