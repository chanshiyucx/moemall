package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("公司收发货地址表")
@Table(name = "`oms_company_address`")
public class OmsCompanyAddress implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 地址名称
     */
    @Column(name = "`address_name`")
    @ApiModelProperty("地址名称")
    private String addressName;

    /**
     * 默认发货地址：0->否；1->是
     */
    @Column(name = "`send_status`")
    @ApiModelProperty("默认发货地址：0->否；1->是")
    private Integer sendStatus;

    /**
     * 是否默认收货地址：0->否；1->是
     */
    @Column(name = "`receive_status`")
    @ApiModelProperty("是否默认收货地址：0->否；1->是")
    private Integer receiveStatus;

    /**
     * 收发货人姓名
     */
    @Column(name = "`name`")
    @ApiModelProperty("收发货人姓名")
    private String name;

    /**
     * 收货人电话
     */
    @Column(name = "`phone`")
    @ApiModelProperty("收货人电话")
    private String phone;

    /**
     * 省/直辖市
     */
    @Column(name = "`province`")
    @ApiModelProperty("省/直辖市")
    private String province;

    /**
     * 市
     */
    @Column(name = "`city`")
    @ApiModelProperty("市")
    private String city;

    /**
     * 区
     */
    @Column(name = "`region`")
    @ApiModelProperty("区")
    private String region;

    /**
     * 详细地址
     */
    @Column(name = "`detail_address`")
    @ApiModelProperty("详细地址")
    private String detailAddress;

    private static final long serialVersionUID = 1L;
}