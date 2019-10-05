package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("首页推荐品牌表")
@Table(name = "`sms_home_brand`")
public class SmsHomeBrand implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`brand_id`")
    @ApiModelProperty("")
    private Long brandId;

    @Column(name = "`brand_name`")
    @ApiModelProperty("")
    private String brandName;

    @Column(name = "`recommend_status`")
    @ApiModelProperty("")
    private Integer recommendStatus;

    @Column(name = "`sort`")
    @ApiModelProperty("")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}