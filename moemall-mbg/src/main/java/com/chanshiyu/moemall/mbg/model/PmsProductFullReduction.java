package com.chanshiyu.moemall.mbg.model;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_product_full_reduction")
public class PmsProductFullReduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "full_price")
    private BigDecimal fullPrice;

    @Column(name = "reduce_price")
    private BigDecimal reducePrice;
}