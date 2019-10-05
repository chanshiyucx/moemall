package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("话题表")
@Table(name = "`cms_topic`")
public class CmsTopic implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`category_id`")
    @ApiModelProperty("")
    private Long categoryId;

    @Column(name = "`name`")
    @ApiModelProperty("")
    private String name;

    @Column(name = "`create_time`")
    @ApiModelProperty("")
    private Date createTime;

    @Column(name = "`start_time`")
    @ApiModelProperty("")
    private Date startTime;

    @Column(name = "`end_time`")
    @ApiModelProperty("")
    private Date endTime;

    /**
     * 参与人数
     */
    @Column(name = "`attend_count`")
    @ApiModelProperty("参与人数")
    private Integer attendCount;

    /**
     * 关注人数
     */
    @Column(name = "`attention_count`")
    @ApiModelProperty("关注人数")
    private Integer attentionCount;

    @Column(name = "`read_count`")
    @ApiModelProperty("")
    private Integer readCount;

    /**
     * 奖品名称
     */
    @Column(name = "`award_name`")
    @ApiModelProperty("奖品名称")
    private String awardName;

    /**
     * 参与方式
     */
    @Column(name = "`attend_type`")
    @ApiModelProperty("参与方式")
    private String attendType;

    /**
     * 话题内容
     */
    @Column(name = "`content`")
    @ApiModelProperty("话题内容")
    private String content;

    private static final long serialVersionUID = 1L;
}