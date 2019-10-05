package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("商品审核记录")
@Table(name = "`pms_product_vertify_record`")
public class PmsProductVertifyRecord implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "`create_time`")
    @ApiModelProperty("")
    private Date createTime;

    /**
     * 审核人
     */
    @Column(name = "`vertify_man`")
    @ApiModelProperty("审核人")
    private String vertifyMan;

    @Column(name = "`status`")
    @ApiModelProperty("")
    private Integer status;

    /**
     * 反馈详情
     */
    @Column(name = "`detail`")
    @ApiModelProperty("反馈详情")
    private String detail;

    private static final long serialVersionUID = 1L;
}