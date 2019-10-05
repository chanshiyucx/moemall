package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("优选专区和产品关系表")
@Table(name = "`cms_prefrence_area_product_relation`")
public class CmsPrefrenceAreaProductRelation implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`prefrence_area_id`")
    @ApiModelProperty("")
    private Long prefrenceAreaId;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    private static final long serialVersionUID = 1L;
}