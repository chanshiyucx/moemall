package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "ums_member_receive_address")
public class UmsMemberReceiveAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    /**
     * 收货人名称
     */
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 是否为默认
     */
    @Column(name = "default_status")
    private Integer defaultStatus;

    /**
     * 邮政编码
     */
    @Column(name = "post_code")
    private String postCode;

    /**
     * 省份/直辖市
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址(街道)
     */
    @Column(name = "detail_address")
    private String detailAddress;
}