package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("产品评价回复表")
@Table(name = "pms_comment_replay")
public class PmsCommentReplay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "comment_id")
    @ApiModelProperty("")
    private Long commentId;

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

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    @ApiModelProperty("评论人员类型；0->会员；1->管理员")
    private Integer type;

    private static final long serialVersionUID = 1L;
}