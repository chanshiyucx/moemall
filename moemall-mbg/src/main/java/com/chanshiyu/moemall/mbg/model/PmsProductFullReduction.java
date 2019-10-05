package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("产品满减表(只针对同商品)")
@Table(name = "`pms_product_full_reduction`")
public class PmsProductFullReduction implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "`full_price`")
    @ApiModelProperty("")
    private BigDecimal fullPrice;

    @Column(name = "`reduce_price`")
    @ApiModelProperty("")
    private BigDecimal reducePrice;

    private static final long serialVersionUID = 1L;
}