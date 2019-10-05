package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("会员与产品分类关系表（用户喜欢的分类）")
@Table(name = "ums_member_product_category_relation")
public class UmsMemberProductCategoryRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "member_id")
    @ApiModelProperty("")
    private Long memberId;

    @Column(name = "product_category_id")
    @ApiModelProperty("")
    private Long productCategoryId;

    private static final long serialVersionUID = 1L;
}