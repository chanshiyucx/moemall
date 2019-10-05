package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("商品评价表")
@Table(name = "`pms_comment`")
public class PmsComment implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "`member_nick_name`")
    @ApiModelProperty("")
    private String memberNickName;

    @Column(name = "`product_name`")
    @ApiModelProperty("")
    private String productName;

    /**
     * 评价星数：0->5
     */
    @Column(name = "`star`")
    @ApiModelProperty("评价星数：0->5")
    private Integer star;

    /**
     * 评价的ip
     */
    @Column(name = "`member_ip`")
    @ApiModelProperty("评价的ip")
    private String memberIp;

    @Column(name = "`create_time`")
    @ApiModelProperty("")
    private Date createTime;

    @Column(name = "`show_status`")
    @ApiModelProperty("")
    private Integer showStatus;

    /**
     * 购买时的商品属性
     */
    @Column(name = "`product_attribute`")
    @ApiModelProperty("购买时的商品属性")
    private String productAttribute;

    @Column(name = "`collect_couont`")
    @ApiModelProperty("")
    private Integer collectCouont;

    @Column(name = "`read_count`")
    @ApiModelProperty("")
    private Integer readCount;

    /**
     * 上传图片地址，以逗号隔开
     */
    @Column(name = "`pics`")
    @ApiModelProperty("上传图片地址，以逗号隔开")
    private String pics;

    /**
     * 评论用户头像
     */
    @Column(name = "`member_icon`")
    @ApiModelProperty("评论用户头像")
    private String memberIcon;

    @Column(name = "`replay_count`")
    @ApiModelProperty("")
    private Integer replayCount;

    @Column(name = "`content`")
    @ApiModelProperty("")
    private String content;

    private static final long serialVersionUID = 1L;
}