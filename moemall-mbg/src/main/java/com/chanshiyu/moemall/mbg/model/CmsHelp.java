package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("帮助表")
@Table(name = "`cms_help`")
public class CmsHelp implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`category_id`")
    @ApiModelProperty("")
    private Long categoryId;

    @Column(name = "`icon`")
    @ApiModelProperty("")
    private String icon;

    @Column(name = "`title`")
    @ApiModelProperty("")
    private String title;

    @Column(name = "`show_status`")
    @ApiModelProperty("")
    private Integer showStatus;

    @Column(name = "`create_time`")
    @ApiModelProperty("")
    private Date createTime;

    @Column(name = "`read_count`")
    @ApiModelProperty("")
    private Integer readCount;

    @Column(name = "`content`")
    @ApiModelProperty("")
    private String content;

    private static final long serialVersionUID = 1L;
}