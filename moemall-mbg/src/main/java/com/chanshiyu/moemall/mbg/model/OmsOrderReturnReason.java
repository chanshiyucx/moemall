package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("退货原因表")
@Table(name = "oms_order_return_reason")
public class OmsOrderReturnReason implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 退货类型
     */
    @ApiModelProperty("退货类型")
    private String name;

    @ApiModelProperty("")
    private Integer sort;

    /**
     * 状态：0->不启用；1->启用
     */
    @ApiModelProperty("状态：0->不启用；1->启用")
    private Integer status;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("添加时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}