package com.chanshiyu.moemall.mbg.model;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_product_ladder")
public class PmsProductLadder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    /**
     * 满足的商品数量
     */
    private Integer count;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 折后价格
     */
    private BigDecimal price;
}