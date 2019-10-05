package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("专题评论表")
@Table(name = "cms_subject_comment")
public class CmsSubjectComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "subject_id")
    @ApiModelProperty("")
    private Long subjectId;

    @Column(name = "member_nick_name")
    @ApiModelProperty("")
    private String memberNickName;

    @Column(name = "member_icon")
    @ApiModelProperty("")
    private String memberIcon;

    @ApiModelProperty("")
    private String content;

    @Column(name = "create_time")
    @ApiModelProperty("")
    private Date createTime;

    @Column(name = "show_status")
    @ApiModelProperty("")
    private Integer showStatus;

    private static final long serialVersionUID = 1L;
}