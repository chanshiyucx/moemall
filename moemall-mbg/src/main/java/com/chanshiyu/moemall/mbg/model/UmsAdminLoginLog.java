package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "ums_admin_login_log")
public class UmsAdminLoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "create_time")
    private Date createTime;

    private String ip;

    private String address;

    /**
     * 浏览器登录类型
     */
    @Column(name = "user_agent")
    private String userAgent;
}