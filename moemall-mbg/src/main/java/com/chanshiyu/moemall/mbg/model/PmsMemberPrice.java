package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("商品会员价格表")
@Table(name = "pms_member_price")
public class PmsMemberPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "product_id")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "member_level_id")
    @ApiModelProperty("")
    private Long memberLevelId;

    /**
     * 会员价格
     */
    @Column(name = "member_price")
    @ApiModelProperty("会员价格")
    private BigDecimal memberPrice;

    @Column(name = "member_level_name")
    @ApiModelProperty("")
    private String memberLevelName;

    private static final long serialVersionUID = 1L;
}