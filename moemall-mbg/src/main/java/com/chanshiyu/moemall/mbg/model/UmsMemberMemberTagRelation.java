package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "ums_member_member_tag_relation")
public class UmsMemberMemberTagRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "tag_id")
    private Long tagId;

    private static final long serialVersionUID = 1L;
}