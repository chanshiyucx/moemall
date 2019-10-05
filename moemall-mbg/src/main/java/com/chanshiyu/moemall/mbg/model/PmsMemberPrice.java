package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_member_price")
public class PmsMemberPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "member_level_id")
    private Long memberLevelId;

    /**
     * 会员价格
     */
    @Column(name = "member_price")
    private BigDecimal memberPrice;

    @Column(name = "member_level_name")
    private String memberLevelName;

    private static final long serialVersionUID = 1L;
}