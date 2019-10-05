package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("用户和标签关系表")
@Table(name = "`ums_member_member_tag_relation`")
public class UmsMemberMemberTagRelation implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`member_id`")
    @ApiModelProperty("")
    private Long memberId;

    @Column(name = "`tag_id`")
    @ApiModelProperty("")
    private Long tagId;

    private static final long serialVersionUID = 1L;
}