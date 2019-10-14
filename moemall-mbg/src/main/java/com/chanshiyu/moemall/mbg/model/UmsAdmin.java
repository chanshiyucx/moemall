package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("后台用户表")
@Table(name = "ums_admin")
public class UmsAdmin implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       @ApiModelProperty("主键ID")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 备注信息
     */
    @ApiModelProperty("备注信息")
    private String note;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;

    private static final long serialVersionUID = 1L;
}