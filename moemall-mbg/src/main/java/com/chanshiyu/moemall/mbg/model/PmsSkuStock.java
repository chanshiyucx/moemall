package com.chanshiyu.moemall.mbg.model;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_sku_stock")
public class PmsSkuStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    /**
     * sku编码
     */
    @Column(name = "sku_code")
    private String skuCode;

    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 预警库存
     */
    @Column(name = "low_stock")
    private Integer lowStock;

    /**
     * 销售属性1
     */
    private String sp1;

    private String sp2;

    private String sp3;

    /**
     * 展示图片
     */
    private String pic;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 单品促销价格
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 锁定库存
     */
    @Column(name = "lock_stock")
    private Integer lockStock;
}