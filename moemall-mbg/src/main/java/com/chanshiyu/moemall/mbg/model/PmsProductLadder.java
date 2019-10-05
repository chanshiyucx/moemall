package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("产品阶梯价格表(只针对同商品)")
@Table(name = "`pms_product_ladder`")
public class PmsProductLadder implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    /**
     * 满足的商品数量
     */
    @Column(name = "`count`")
    @ApiModelProperty("满足的商品数量")
    private Integer count;

    /**
     * 折扣
     */
    @Column(name = "`discount`")
    @ApiModelProperty("折扣")
    private BigDecimal discount;

    /**
     * 折后价格
     */
    @Column(name = "`price`")
    @ApiModelProperty("折后价格")
    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}