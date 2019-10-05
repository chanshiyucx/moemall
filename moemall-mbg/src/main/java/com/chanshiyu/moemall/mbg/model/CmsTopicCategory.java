package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("话题分类表")
@Table(name = "`cms_topic_category`")
public class CmsTopicCategory implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`name`")
    @ApiModelProperty("")
    private String name;

    /**
     * 分类图标
     */
    @Column(name = "`icon`")
    @ApiModelProperty("分类图标")
    private String icon;

    /**
     * 专题数量
     */
    @Column(name = "`subject_count`")
    @ApiModelProperty("专题数量")
    private Integer subjectCount;

    @Column(name = "`show_status`")
    @ApiModelProperty("")
    private Integer showStatus;

    @Column(name = "`sort`")
    @ApiModelProperty("")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}