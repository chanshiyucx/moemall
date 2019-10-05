package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("后台用户和角色关系表")
@Table(name = "`ums_admin_role_relation`")
public class UmsAdminRoleRelation implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`admin_id`")
    @ApiModelProperty("")
    private Long adminId;

    @Column(name = "`role_id`")
    @ApiModelProperty("")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}