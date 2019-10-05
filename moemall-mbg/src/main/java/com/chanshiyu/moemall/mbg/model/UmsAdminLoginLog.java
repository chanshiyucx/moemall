package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("后台用户登录日志表")
@Table(name = "ums_admin_login_log")
public class UmsAdminLoginLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "admin_id")
    @ApiModelProperty("")
    private Long adminId;

    @Column(name = "create_time")
    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("")
    private String ip;

    @ApiModelProperty("")
    private String address;

    /**
     * 浏览器登录类型
     */
    @Column(name = "user_agent")
    @ApiModelProperty("浏览器登录类型")
    private String userAgent;

    private static final long serialVersionUID = 1L;
}