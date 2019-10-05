package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("商品限时购与商品关系表")
@Table(name = "`sms_flash_promotion_product_relation`")
public class SmsFlashPromotionProductRelation implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("编号")
    private Long id;

    @Column(name = "`flash_promotion_id`")
    @ApiModelProperty("")
    private Long flashPromotionId;

    /**
     * 编号
     */
    @Column(name = "`flash_promotion_session_id`")
    @ApiModelProperty("编号")
    private Long flashPromotionSessionId;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    /**
     * 限时购价格
     */
    @Column(name = "`flash_promotion_price`")
    @ApiModelProperty("限时购价格")
    private BigDecimal flashPromotionPrice;

    /**
     * 限时购数量
     */
    @Column(name = "`flash_promotion_count`")
    @ApiModelProperty("限时购数量")
    private Integer flashPromotionCount;

    /**
     * 每人限购数量
     */
    @Column(name = "`flash_promotion_limit`")
    @ApiModelProperty("每人限购数量")
    private Integer flashPromotionLimit;

    /**
     * 排序
     */
    @Column(name = "`sort`")
    @ApiModelProperty("排序")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}