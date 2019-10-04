package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "ums_member_login_log")
public class UmsMemberLoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "create_time")
    private Date createTime;

    private String ip;

    private String city;

    /**
     * 登录类型：0->PC；1->android;2->ios;3->小程序
     */
    @Column(name = "login_type")
    private Integer loginType;

    private String province;
}