package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("相册表")
@Table(name = "`pms_album`")
public class PmsAlbum implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`name`")
    @ApiModelProperty("")
    private String name;

    @Column(name = "`cover_pic`")
    @ApiModelProperty("")
    private String coverPic;

    @Column(name = "`pic_count`")
    @ApiModelProperty("")
    private Integer picCount;

    @Column(name = "`sort`")
    @ApiModelProperty("")
    private Integer sort;

    @Column(name = "`description`")
    @ApiModelProperty("")
    private String description;

    private static final long serialVersionUID = 1L;
}