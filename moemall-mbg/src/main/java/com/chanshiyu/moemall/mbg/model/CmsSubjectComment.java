package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "cms_subject_comment")
public class CmsSubjectComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "member_nick_name")
    private String memberNickName;

    @Column(name = "member_icon")
    private String memberIcon;

    private String content;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "show_status")
    private Integer showStatus;
}