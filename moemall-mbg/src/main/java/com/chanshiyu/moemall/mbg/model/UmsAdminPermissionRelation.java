package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("后台用户和权限关系表(除角色中定义的权限以外的加减权限)")
@Table(name = "ums_admin_permission_relation")
public class UmsAdminPermissionRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "admin_id")
    @ApiModelProperty("")
    private Long adminId;

    @Column(name = "permission_id")
    @ApiModelProperty("")
    private Long permissionId;

    @ApiModelProperty("")
    private Integer type;

    private static final long serialVersionUID = 1L;
}