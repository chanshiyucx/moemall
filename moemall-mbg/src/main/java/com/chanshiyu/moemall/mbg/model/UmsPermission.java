package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("后台用户权限表")
@Table(name = "ums_permission")
public class UmsPermission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 父级权限id
     */
    @ApiModelProperty("父级权限id")
    private Long pid;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 权限值
     */
    @ApiModelProperty("权限值")
    private String value;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    @ApiModelProperty("权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    private Integer type;

    /**
     * 前端资源路径
     */
    @ApiModelProperty("前端资源路径")
    private String uri;

    /**
     * 启用状态；0->禁用；1->启用
     */
    @ApiModelProperty("启用状态；0->禁用；1->启用")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}