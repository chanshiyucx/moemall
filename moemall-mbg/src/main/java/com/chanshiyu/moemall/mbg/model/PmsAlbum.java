package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_album")
public class PmsAlbum implements Serializable {
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

    private static final long serialVersionUID = 1L;
}