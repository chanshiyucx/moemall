package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "cms_prefrence_area")
public class CmsPrefrenceArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "sub_title")
    private String subTitle;

    private Integer sort;

    @Column(name = "show_status")
    private Integer showStatus;

    /**
     * 展示图片
     */
    private byte[] pic;
}