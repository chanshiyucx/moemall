package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms_home_advertise")
public class SmsHomeAdvertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    private Integer type;

    private String pic;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 上下线状态：0->下线；1->上线
     */
    private Integer status;

    /**
     * 点击数
     */
    @Column(name = "click_count")
    private Integer clickCount;

    /**
     * 下单数
     */
    @Column(name = "order_count")
    private Integer orderCount;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 备注
     */
    private String note;

    /**
     * 排序
     */
    private Integer sort;
}