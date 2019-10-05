package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("专题表")
@Table(name = "`cms_subject`")
public class CmsSubject implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`category_id`")
    @ApiModelProperty("")
    private Long categoryId;

    @Column(name = "`title`")
    @ApiModelProperty("")
    private String title;

    /**
     * 专题主图
     */
    @Column(name = "`pic`")
    @ApiModelProperty("专题主图")
    private String pic;

    /**
     * 关联产品数量
     */
    @Column(name = "`product_count`")
    @ApiModelProperty("关联产品数量")
    private Integer productCount;

    @Column(name = "`recommend_status`")
    @ApiModelProperty("")
    private Integer recommendStatus;

    @Column(name = "`create_time`")
    @ApiModelProperty("")
    private Date createTime;

    @Column(name = "`collect_count`")
    @ApiModelProperty("")
    private Integer collectCount;

    @Column(name = "`read_count`")
    @ApiModelProperty("")
    private Integer readCount;

    @Column(name = "`comment_count`")
    @ApiModelProperty("")
    private Integer commentCount;

    /**
     * 画册图片用逗号分割
     */
    @Column(name = "`album_pics`")
    @ApiModelProperty("画册图片用逗号分割")
    private String albumPics;

    @Column(name = "`description`")
    @ApiModelProperty("")
    private String description;

    /**
     * 显示状态：0->不显示；1->显示
     */
    @Column(name = "`show_status`")
    @ApiModelProperty("显示状态：0->不显示；1->显示")
    private Integer showStatus;

    /**
     * 转发数
     */
    @Column(name = "`forward_count`")
    @ApiModelProperty("转发数")
    private Integer forwardCount;

    /**
     * 专题分类名称
     */
    @Column(name = "`category_name`")
    @ApiModelProperty("专题分类名称")
    private String categoryName;

    @Column(name = "`content`")
    @ApiModelProperty("")
    private String content;

    private static final long serialVersionUID = 1L;
}