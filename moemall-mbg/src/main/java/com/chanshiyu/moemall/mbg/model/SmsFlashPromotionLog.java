package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("限时购通知记录")
@Table(name = "sms_flash_promotion_log")
public class SmsFlashPromotionLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Integer id;

    @Column(name = "member_id")
    @ApiModelProperty("")
    private Integer memberId;

    @Column(name = "product_id")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "member_phone")
    @ApiModelProperty("")
    private String memberPhone;

    @Column(name = "product_name")
    @ApiModelProperty("")
    private String productName;

    /**
     * 会员订阅时间
     */
    @Column(name = "subscribe_time")
    @ApiModelProperty("会员订阅时间")
    private Date subscribeTime;

    @Column(name = "send_time")
    @ApiModelProperty("")
    private Date sendTime;

    private static final long serialVersionUID = 1L;
}