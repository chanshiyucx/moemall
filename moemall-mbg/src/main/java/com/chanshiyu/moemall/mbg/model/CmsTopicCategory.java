package com.chanshiyu.moemall.mbg.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "cms_topic_category")
public class CmsTopicCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 分类图标
     */
    private String icon;

    /**
     * 专题数量
     */
    @Column(name = "subject_count")
    private Integer subjectCount;

    @Column(name = "show_status")
    private Integer showStatus;

    private Integer sort;
}