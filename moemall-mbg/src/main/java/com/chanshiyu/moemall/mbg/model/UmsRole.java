package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("后台用户角色表")
@Table(name = "`ums_role`")
public class UmsRole implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "`name`")
    @ApiModelProperty("名称")
    private String name;

    /**
     * 描述
     */
    @Column(name = "`description`")
    @ApiModelProperty("描述")
    private String description;

    /**
     * 后台用户数量
     */
    @Column(name = "`admin_count`")
    @ApiModelProperty("后台用户数量")
    private Integer adminCount;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 启用状态：0->禁用；1->启用
     */
    @Column(name = "`status`")
    @ApiModelProperty("启用状态：0->禁用；1->启用")
    private Integer status;

    @Column(name = "`sort`")
    @ApiModelProperty("")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}