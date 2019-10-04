package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms_flash_promotion")
public class SmsFlashPromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    /**
     * 开始日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 结束日期
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 上下线状态
     */
    private Integer status;

    /**
     * 秒杀时间段名称
     */
    @Column(name = "create_time")
    private Date createTime;
}