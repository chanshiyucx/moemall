package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("订单操作历史记录")
@Table(name = "`oms_order_operate_history`")
public class OmsOrderOperateHistory implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "`order_id`")
    @ApiModelProperty("订单id")
    private Long orderId;

    /**
     * 操作人：用户；系统；后台管理员
     */
    @Column(name = "`operate_man`")
    @ApiModelProperty("操作人：用户；系统；后台管理员")
    private String operateMan;

    /**
     * 操作时间
     */
    @Column(name = "`create_time`")
    @ApiModelProperty("操作时间")
    private Date createTime;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @Column(name = "`order_status`")
    @ApiModelProperty("订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer orderStatus;

    /**
     * 备注
     */
    @Column(name = "`note`")
    @ApiModelProperty("备注")
    private String note;

    private static final long serialVersionUID = 1L;
}