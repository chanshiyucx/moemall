package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_album")
public class PmsAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "cover_pic")
    private String coverPic;

    @Column(name = "pic_count")
    private Integer picCount;

    private Integer sort;

    private String description;
}