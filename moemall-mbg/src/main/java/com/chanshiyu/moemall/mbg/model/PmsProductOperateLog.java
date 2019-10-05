package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("")
@Table(name = "pms_product_operate_log")
public class PmsProductOperateLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "product_id")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "price_old")
    @ApiModelProperty("")
    private BigDecimal priceOld;

    @Column(name = "price_new")
    @ApiModelProperty("")
    private BigDecimal priceNew;

    @Column(name = "sale_price_old")
    @ApiModelProperty("")
    private BigDecimal salePriceOld;

    @Column(name = "sale_price_new")
    @ApiModelProperty("")
    private BigDecimal salePriceNew;

    /**
     * 赠送的积分
     */
    @Column(name = "gift_point_old")
    @ApiModelProperty("赠送的积分")
    private Integer giftPointOld;

    @Column(name = "gift_point_new")
    @ApiModelProperty("")
    private Integer giftPointNew;

    @Column(name = "use_point_limit_old")
    @ApiModelProperty("")
    private Integer usePointLimitOld;

    @Column(name = "use_point_limit_new")
    @ApiModelProperty("")
    private Integer usePointLimitNew;

    /**
     * 操作人
     */
    @Column(name = "operate_man")
    @ApiModelProperty("操作人")
    private String operateMan;

    @Column(name = "create_time")
    @ApiModelProperty("")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}