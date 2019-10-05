package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("专题商品关系表")
@Table(name = "`cms_subject_product_relation`")
public class CmsSubjectProductRelation implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`subject_id`")
    @ApiModelProperty("")
    private Long subjectId;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    private static final long serialVersionUID = 1L;
}