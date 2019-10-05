package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("会员登录记录")
@Table(name = "ums_member_login_log")
public class UmsMemberLoginLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "member_id")
    @ApiModelProperty("")
    private Long memberId;

    @Column(name = "create_time")
    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("")
    private String ip;

    @ApiModelProperty("")
    private String city;

    /**
     * 登录类型：0->PC；1->android;2->ios;3->小程序
     */
    @Column(name = "login_type")
    @ApiModelProperty("登录类型：0->PC；1->android;2->ios;3->小程序")
    private Integer loginType;

    @ApiModelProperty("")
    private String province;

    private static final long serialVersionUID = 1L;
}