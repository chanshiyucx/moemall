package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "oms_company_address")
public class OmsCompanyAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 地址名称
     */
    @Column(name = "address_name")
    private String addressName;

    /**
     * 默认发货地址：0->否；1->是
     */
    @Column(name = "send_status")
    private Integer sendStatus;

    /**
     * 是否默认收货地址：0->否；1->是
     */
    @Column(name = "receive_status")
    private Integer receiveStatus;

    /**
     * 收发货人姓名
     */
    private String name;

    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 省/直辖市
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址
     */
    @Column(name = "detail_address")
    private String detailAddress;

    private static final long serialVersionUID = 1L;
}