package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("画册图片表")
@Table(name = "`pms_album_pic`")
public class PmsAlbumPic implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`album_id`")
    @ApiModelProperty("")
    private Long albumId;

    @Column(name = "`pic`")
    @ApiModelProperty("")
    private String pic;

    private static final long serialVersionUID = 1L;
}