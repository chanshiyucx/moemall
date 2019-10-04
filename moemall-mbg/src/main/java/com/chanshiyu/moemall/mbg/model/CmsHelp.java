package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "cms_help")
public class CmsHelp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    private String icon;

    private String title;

    @Column(name = "show_status")
    private Integer showStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "read_count")
    private Integer readCount;

    private String content;
}