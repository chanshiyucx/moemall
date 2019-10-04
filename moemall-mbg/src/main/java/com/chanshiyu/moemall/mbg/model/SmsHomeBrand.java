package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms_home_brand")
public class SmsHomeBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    private Integer sort;
}