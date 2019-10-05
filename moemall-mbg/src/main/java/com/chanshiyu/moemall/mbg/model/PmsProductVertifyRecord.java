package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_product_vertify_record")
public class PmsProductVertifyRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 审核人
     */
    @Column(name = "vertify_man")
    private String vertifyMan;

    private Integer status;

    /**
     * 反馈详情
     */
    private String detail;

    private static final long serialVersionUID = 1L;
}