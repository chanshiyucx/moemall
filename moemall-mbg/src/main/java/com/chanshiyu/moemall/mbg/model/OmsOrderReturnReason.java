package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "oms_order_return_reason")
public class OmsOrderReturnReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 退货类型
     */
    private String name;

    private Integer sort;

    /**
     * 状态：0->不启用；1->启用
     */
    private Integer status;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;
}