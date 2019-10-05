package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("用户标签表")
@Table(name = "`ums_member_tag`")
public class UmsMemberTag implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`name`")
    @ApiModelProperty("")
    private String name;

    /**
     * 自动打标签完成订单数量
     */
    @Column(name = "`finish_order_count`")
    @ApiModelProperty("自动打标签完成订单数量")
    private Integer finishOrderCount;

    /**
     * 自动打标签完成订单金额
     */
    @Column(name = "`finish_order_amount`")
    @ApiModelProperty("自动打标签完成订单金额")
    private BigDecimal finishOrderAmount;

    private static final long serialVersionUID = 1L;
}