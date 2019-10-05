package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pms_product")
public class PmsProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "feight_template_id")
    private Long feightTemplateId;

    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    private String pic;

    /**
     * 货号
     */
    @Column(name = "product_sn")
    private String productSn;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * 上架状态：0->下架；1->上架
     */
    @Column(name = "publish_status")
    private Integer publishStatus;

    /**
     * 新品状态:0->不是新品；1->新品
     */
    @Column(name = "new_status")
    private Integer newStatus;

    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    @Column(name = "recommand_status")
    private Integer recommandStatus;

    /**
     * 审核状态：0->未审核；1->审核通过
     */
    @Column(name = "verify_status")
    private Integer verifyStatus;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 销量
     */
    private Integer sale;

    private BigDecimal price;

    /**
     * 促销价格
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 赠送的成长值
     */
    @Column(name = "gift_growth")
    private Integer giftGrowth;

    /**
     * 赠送的积分
     */
    @Column(name = "gift_point")
    private Integer giftPoint;

    /**
     * 限制使用的积分数
     */
    @Column(name = "use_point_limit")
    private Integer usePointLimit;

    /**
     * 副标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 市场价
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 库存预警值
     */
    @Column(name = "low_stock")
    private Integer lowStock;

    /**
     * 单位
     */
    private String unit;

    /**
     * 商品重量，默认为克
     */
    private BigDecimal weight;

    /**
     * 是否为预告商品：0->不是；1->是
     */
    @Column(name = "preview_status")
    private Integer previewStatus;

    /**
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    @Column(name = "service_ids")
    private String serviceIds;

    private String keywords;

    private String note;

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     */
    @Column(name = "album_pics")
    private String albumPics;

    @Column(name = "detail_title")
    private String detailTitle;

    /**
     * 促销开始时间
     */
    @Column(name = "promotion_start_time")
    private Date promotionStartTime;

    /**
     * 促销结束时间
     */
    @Column(name = "promotion_end_time")
    private Date promotionEndTime;

    /**
     * 活动限购数量
     */
    @Column(name = "promotion_per_limit")
    private Integer promotionPerLimit;

    /**
     * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     */
    @Column(name = "promotion_type")
    private Integer promotionType;

    /**
     * 品牌名称
     */
    @Column(name = "brand_name")
    private String brandName;

    /**
     * 商品分类名称
     */
    @Column(name = "product_category_name")
    private String productCategoryName;

    /**
     * 商品描述
     */
    private String description;

    @Column(name = "detail_desc")
    private String detailDesc;

    /**
     * 产品详情网页内容
     */
    @Column(name = "detail_html")
    private String detailHtml;

    /**
     * 移动端网页详情
     */
    @Column(name = "detail_mobile_html")
    private String detailMobileHtml;

    private static final long serialVersionUID = 1L;
}