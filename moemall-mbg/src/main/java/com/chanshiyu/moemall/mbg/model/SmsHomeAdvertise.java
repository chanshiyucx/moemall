package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("首页轮播广告表")
@Table(name = "`sms_home_advertise`")
public class SmsHomeAdvertise implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`name`")
    @ApiModelProperty("")
    private String name;

    /**
     * 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    @Column(name = "`type`")
    @ApiModelProperty("轮播位置：0->PC首页轮播；1->app首页轮播")
    private Integer type;

    @Column(name = "`pic`")
    @ApiModelProperty("")
    private String pic;

    @Column(name = "`start_time`")
    @ApiModelProperty("")
    private Date startTime;

    @Column(name = "`end_time`")
    @ApiModelProperty("")
    private Date endTime;

    /**
     * 上下线状态：0->下线；1->上线
     */
    @Column(name = "`status`")
    @ApiModelProperty("上下线状态：0->下线；1->上线")
    private Integer status;

    /**
     * 点击数
     */
    @Column(name = "`click_count`")
    @ApiModelProperty("点击数")
    private Integer clickCount;

    /**
     * 下单数
     */
    @Column(name = "`order_count`")
    @ApiModelProperty("下单数")
    private Integer orderCount;

    /**
     * 链接地址
     */
    @Column(name = "`url`")
    @ApiModelProperty("链接地址")
    private String url;

    /**
     * 备注
     */
    @Column(name = "`note`")
    @ApiModelProperty("备注")
    private String note;

    /**
     * 排序
     */
    @Column(name = "`sort`")
    @ApiModelProperty("排序")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}