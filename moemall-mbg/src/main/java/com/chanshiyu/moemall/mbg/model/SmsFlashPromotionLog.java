package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms_flash_promotion_log")
public class SmsFlashPromotionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "member_phone")
    private String memberPhone;

    @Column(name = "product_name")
    private String productName;

    /**
     * 会员订阅时间
     */
    @Column(name = "subscribe_time")
    private Date subscribeTime;

    @Column(name = "send_time")
    private Date sendTime;
}