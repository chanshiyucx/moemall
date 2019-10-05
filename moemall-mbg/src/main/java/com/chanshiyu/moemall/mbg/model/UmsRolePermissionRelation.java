package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("后台用户角色和权限关系表")
@Table(name = "`ums_role_permission_relation`")
public class UmsRolePermissionRelation implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`role_id`")
    @ApiModelProperty("")
    private Long roleId;

    @Column(name = "`permission_id`")
    @ApiModelProperty("")
    private Long permissionId;

    private static final long serialVersionUID = 1L;
}