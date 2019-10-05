package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms_home_recommend_product")
public class SmsHomeRecommendProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    private Integer sort;

    private static final long serialVersionUID = 1L;
}