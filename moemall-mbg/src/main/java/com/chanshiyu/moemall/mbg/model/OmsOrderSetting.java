package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("订单设置表")
@Table(name = "oms_order_setting")
public class OmsOrderSetting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    @Column(name = "flash_order_overtime")
    @ApiModelProperty("秒杀订单超时关闭时间(分)")
    private Integer flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    @Column(name = "normal_order_overtime")
    @ApiModelProperty("正常订单超时时间(分)")
    private Integer normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    @Column(name = "confirm_overtime")
    @ApiModelProperty("发货后自动确认收货时间（天）")
    private Integer confirmOvertime;

    /**
     * 自动完成交易时间，不能申请售后（天）
     */
    @Column(name = "finish_overtime")
    @ApiModelProperty("自动完成交易时间，不能申请售后（天）")
    private Integer finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    @Column(name = "comment_overtime")
    @ApiModelProperty("订单完成后自动好评时间（天）")
    private Integer commentOvertime;

    private static final long serialVersionUID = 1L;
}