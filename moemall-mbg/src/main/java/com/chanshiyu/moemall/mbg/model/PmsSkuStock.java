package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("sku的库存")
@Table(name = "`pms_sku_stock`")
public class PmsSkuStock implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    /**
     * sku编码
     */
    @Column(name = "`sku_code`")
    @ApiModelProperty("sku编码")
    private String skuCode;

    @Column(name = "`price`")
    @ApiModelProperty("")
    private BigDecimal price;

    /**
     * 库存
     */
    @Column(name = "`stock`")
    @ApiModelProperty("库存")
    private Integer stock;

    /**
     * 预警库存
     */
    @Column(name = "`low_stock`")
    @ApiModelProperty("预警库存")
    private Integer lowStock;

    /**
     * 销售属性1
     */
    @Column(name = "`sp1`")
    @ApiModelProperty("销售属性1")
    private String sp1;

    @Column(name = "`sp2`")
    @ApiModelProperty("")
    private String sp2;

    @Column(name = "`sp3`")
    @ApiModelProperty("")
    private String sp3;

    /**
     * 展示图片
     */
    @Column(name = "`pic`")
    @ApiModelProperty("展示图片")
    private String pic;

    /**
     * 销量
     */
    @Column(name = "`sale`")
    @ApiModelProperty("销量")
    private Integer sale;

    /**
     * 单品促销价格
     */
    @Column(name = "`promotion_price`")
    @ApiModelProperty("单品促销价格")
    private BigDecimal promotionPrice;

    /**
     * 锁定库存
     */
    @Column(name = "`lock_stock`")
    @ApiModelProperty("锁定库存")
    private Integer lockStock;

    private static final long serialVersionUID = 1L;
}