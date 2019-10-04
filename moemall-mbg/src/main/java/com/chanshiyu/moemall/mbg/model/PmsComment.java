package com.chanshiyu.moemall.mbg.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_comment")
public class PmsComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "member_nick_name")
    private String memberNickName;

    @Column(name = "product_name")
    private String productName;

    /**
     * 评价星数：0->5
     */
    private Integer star;

    /**
     * 评价的ip
     */
    @Column(name = "member_ip")
    private String memberIp;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "show_status")
    private Integer showStatus;

    /**
     * 购买时的商品属性
     */
    @Column(name = "product_attribute")
    private String productAttribute;

    @Column(name = "collect_couont")
    private Integer collectCouont;

    @Column(name = "read_count")
    private Integer readCount;

    /**
     * 上传图片地址，以逗号隔开
     */
    private String pics;

    /**
     * 评论用户头像
     */
    @Column(name = "member_icon")
    private String memberIcon;

    @Column(name = "replay_count")
    private Integer replayCount;

    private String content;
}