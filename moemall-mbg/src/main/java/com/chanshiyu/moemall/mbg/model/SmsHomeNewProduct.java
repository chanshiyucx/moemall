package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("新鲜好物表")
@Table(name = "`sms_home_new_product`")
public class SmsHomeNewProduct implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "`product_name`")
    @ApiModelProperty("")
    private String productName;

    @Column(name = "`recommend_status`")
    @ApiModelProperty("")
    private Integer recommendStatus;

    @Column(name = "`sort`")
    @ApiModelProperty("")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}