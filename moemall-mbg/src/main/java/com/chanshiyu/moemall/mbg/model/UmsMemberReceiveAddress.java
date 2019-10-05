package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("会员收货地址表")
@Table(name = "`ums_member_receive_address`")
public class UmsMemberReceiveAddress implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`member_id`")
    @ApiModelProperty("")
    private Long memberId;

    /**
     * 收货人名称
     */
    @Column(name = "`name`")
    @ApiModelProperty("收货人名称")
    private String name;

    @Column(name = "`phone_number`")
    @ApiModelProperty("")
    private String phoneNumber;

    /**
     * 是否为默认
     */
    @Column(name = "`default_status`")
    @ApiModelProperty("是否为默认")
    private Integer defaultStatus;

    /**
     * 邮政编码
     */
    @Column(name = "`post_code`")
    @ApiModelProperty("邮政编码")
    private String postCode;

    /**
     * 省份/直辖市
     */
    @Column(name = "`province`")
    @ApiModelProperty("省份/直辖市")
    private String province;

    /**
     * 城市
     */
    @Column(name = "`city`")
    @ApiModelProperty("城市")
    private String city;

    /**
     * 区
     */
    @Column(name = "`region`")
    @ApiModelProperty("区")
    private String region;

    /**
     * 详细地址(街道)
     */
    @Column(name = "`detail_address`")
    @ApiModelProperty("详细地址(街道)")
    private String detailAddress;

    private static final long serialVersionUID = 1L;
}