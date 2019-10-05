package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "cms_subject")
public class CmsSubject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    private String title;

    /**
     * 专题主图
     */
    private String pic;

    /**
     * 关联产品数量
     */
    @Column(name = "product_count")
    private Integer productCount;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "collect_count")
    private Integer collectCount;

    @Column(name = "read_count")
    private Integer readCount;

    @Column(name = "comment_count")
    private Integer commentCount;

    /**
     * 画册图片用逗号分割
     */
    @Column(name = "album_pics")
    private String albumPics;

    private String description;

    /**
     * 显示状态：0->不显示；1->显示
     */
    @Column(name = "show_status")
    private Integer showStatus;

    /**
     * 转发数
     */
    @Column(name = "forward_count")
    private Integer forwardCount;

    /**
     * 专题分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    private String content;

    private static final long serialVersionUID = 1L;
}