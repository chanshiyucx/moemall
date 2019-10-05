package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("专题分类表")
@Table(name = "cms_subject_category")
public class CmsSubjectCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String name;

    /**
     * 分类图标
     */
    @ApiModelProperty("分类图标")
    private String icon;

    /**
     * 专题数量
     */
    @Column(name = "subject_count")
    @ApiModelProperty("专题数量")
    private Integer subjectCount;

    @Column(name = "show_status")
    @ApiModelProperty("")
    private Integer showStatus;

    @ApiModelProperty("")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}