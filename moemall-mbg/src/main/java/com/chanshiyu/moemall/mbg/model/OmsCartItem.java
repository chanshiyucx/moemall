package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("购物车表")
@Table(name = "`oms_cart_item`")
public class OmsCartItem implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`product_id`")
    @ApiModelProperty("")
    private Long productId;

    @Column(name = "`product_sku_id`")
    @ApiModelProperty("")
    private Long productSkuId;

    @Column(name = "`member_id`")
    @ApiModelProperty("")
    private Long memberId;

    /**
     * 购买数量
     */
    @Column(name = "`quantity`")
    @ApiModelProperty("购买数量")
    private Integer quantity;

    /**
     * 添加到购物车的价格
     */
    @Column(name = "`price`")
    @ApiModelProperty("添加到购物车的价格")
    private BigDecimal price;

    /**
     * 销售属性1
     */
    @Column(name = "`sp1`")
    @ApiModelProperty("销售属性1")
    private String sp1;

    /**
     * 销售属性2
     */
    @Column(name = "`sp2`")
    @ApiModelProperty("销售属性2")
    private String sp2;

    /**
     * 销售属性3
     */
    @Column(name = "`sp3`")
    @ApiModelProperty("销售属性3")
    private String sp3;

    /**
     * 商品主图
     */
    @Column(name = "`product_pic`")
    @ApiModelProperty("商品主图")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "`product_name`")
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 商品副标题（卖点）
     */
    @Column(name = "`product_sub_title`")
    @ApiModelProperty("商品副标题（卖点）")
    private String productSubTitle;

    /**
     * 商品sku条码
     */
    @Column(name = "`product_sku_code`")
    @ApiModelProperty("商品sku条码")
    private String productSkuCode;

    /**
     * 会员昵称
     */
    @Column(name = "`member_nickname`")
    @ApiModelProperty("会员昵称")
    private String memberNickname;

    /**
     * 创建时间
     */
    @Column(name = "`create_date`")
    @ApiModelProperty("创建时间")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "`modify_date`")
    @ApiModelProperty("修改时间")
    private Date modifyDate;

    /**
     * 是否删除
     */
    @Column(name = "`delete_status`")
    @ApiModelProperty("是否删除")
    private Integer deleteStatus;

    /**
     * 商品分类
     */
    @Column(name = "`product_category_id`")
    @ApiModelProperty("商品分类")
    private Long productCategoryId;

    @Column(name = "`product_brand`")
    @ApiModelProperty("")
    private String productBrand;

    @Column(name = "`product_sn`")
    @ApiModelProperty("")
    private String productSn;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    @Column(name = "`product_attr`")
    @ApiModelProperty("商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]")
    private String productAttr;

    private static final long serialVersionUID = 1L;
}