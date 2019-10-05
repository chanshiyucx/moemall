package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("限时购场次表")
@Table(name = "sms_flash_promotion_session")
public class SmsFlashPromotionSession implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("编号")
    private Long id;

    /**
     * 场次名称
     */
    @ApiModelProperty("场次名称")
    private String name;

    /**
     * 每日开始时间
     */
    @Column(name = "start_time")
    @ApiModelProperty("每日开始时间")
    private Date startTime;

    /**
     * 每日结束时间
     */
    @Column(name = "end_time")
    @ApiModelProperty("每日结束时间")
    private Date endTime;

    /**
     * 启用状态：0->不启用；1->启用
     */
    @ApiModelProperty("启用状态：0->不启用；1->启用")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}