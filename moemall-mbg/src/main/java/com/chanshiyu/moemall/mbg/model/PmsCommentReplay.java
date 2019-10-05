package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_comment_replay")
public class PmsCommentReplay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "member_nick_name")
    private String memberNickName;

    @Column(name = "member_icon")
    private String memberIcon;

    private String content;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    private Integer type;

    private static final long serialVersionUID = 1L;
}