package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "cms_prefrence_area_product_relation")
public class CmsPrefrenceAreaProductRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prefrence_area_id")
    private Long prefrenceAreaId;

    @Column(name = "product_id")
    private Long productId;

    private static final long serialVersionUID = 1L;
}