package com.chanshiyu.moemall.mbg.model;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "ums_member_tag")
public class UmsMemberTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 自动打标签完成订单数量
     */
    @Column(name = "finish_order_count")
    private Integer finishOrderCount;

    /**
     * 自动打标签完成订单金额
     */
    @Column(name = "finish_order_amount")
    private BigDecimal finishOrderAmount;
}