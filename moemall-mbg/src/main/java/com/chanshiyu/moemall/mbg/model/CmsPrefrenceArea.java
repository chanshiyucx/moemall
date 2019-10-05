package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("优选专区")
@Table(name = "cms_prefrence_area")
public class CmsPrefrenceArea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("")
    private String name;

    @Column(name = "sub_title")
    @ApiModelProperty("")
    private String subTitle;

    @ApiModelProperty("")
    private Integer sort;

    @Column(name = "show_status")
    @ApiModelProperty("")
    private Integer showStatus;

    /**
     * 展示图片
     */
    @ApiModelProperty("展示图片")
    private byte[] pic;

    private static final long serialVersionUID = 1L;
}