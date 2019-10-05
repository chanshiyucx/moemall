package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("商品信息")
@Table(name = "`pms_product`")
public class PmsProduct implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`brand_id`")
    @ApiModelProperty("")
    private Long brandId;

    @Column(name = "`product_category_id`")
    @ApiModelProperty("")
    private Long productCategoryId;

    @Column(name = "`feight_template_id`")
    @ApiModelProperty("")
    private Long feightTemplateId;

    @Column(name = "`product_attribute_category_id`")
    @ApiModelProperty("")
    private Long productAttributeCategoryId;

    @Column(name = "`name`")
    @ApiModelProperty("")
    private String name;

    @Column(name = "`pic`")
    @ApiModelProperty("")
    private String pic;

    /**
     * 货号
     */
    @Column(name = "`product_sn`")
    @ApiModelProperty("货号")
    private String productSn;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    @Column(name = "`delete_status`")
    @ApiModelProperty("删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    /**
     * 上架状态：0->下架；1->上架
     */
    @Column(name = "`publish_status`")
    @ApiModelProperty("上架状态：0->下架；1->上架")
    private Integer publishStatus;

    /**
     * 新品状态:0->不是新品；1->新品
     */
    @Column(name = "`new_status`")
    @ApiModelProperty("新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    @Column(name = "`recommand_status`")
    @ApiModelProperty("推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;

    /**
     * 审核状态：0->未审核；1->审核通过
     */
    @Column(name = "`verify_status`")
    @ApiModelProperty("审核状态：0->未审核；1->审核通过")
    private Integer verifyStatus;

    /**
     * 排序
     */
    @Column(name = "`sort`")
    @ApiModelProperty("排序")
    private Integer sort;

    /**
     * 销量
     */
    @Column(name = "`sale`")
    @ApiModelProperty("销量")
    private Integer sale;

    @Column(name = "`price`")
    @ApiModelProperty("")
    private BigDecimal price;

    /**
     * 促销价格
     */
    @Column(name = "`promotion_price`")
    @ApiModelProperty("促销价格")
    private BigDecimal promotionPrice;

    /**
     * 赠送的成长值
     */
    @Column(name = "`gift_growth`")
    @ApiModelProperty("赠送的成长值")
    private Integer giftGrowth;

    /**
     * 赠送的积分
     */
    @Column(name = "`gift_point`")
    @ApiModelProperty("赠送的积分")
    private Integer giftPoint;

    /**
     * 限制使用的积分数
     */
    @Column(name = "`use_point_limit`")
    @ApiModelProperty("限制使用的积分数")
    private Integer usePointLimit;

    /**
     * 副标题
     */
    @Column(name = "`sub_title`")
    @ApiModelProperty("副标题")
    private String subTitle;

    /**
     * 市场价
     */
    @Column(name = "`original_price`")
    @ApiModelProperty("市场价")
    private BigDecimal originalPrice;

    /**
     * 库存
     */
    @Column(name = "`stock`")
    @ApiModelProperty("库存")
    private Integer stock;

    /**
     * 库存预警值
     */
    @Column(name = "`low_stock`")
    @ApiModelProperty("库存预警值")
    private Integer lowStock;

    /**
     * 单位
     */
    @Column(name = "`unit`")
    @ApiModelProperty("单位")
    private String unit;

    /**
     * 商品重量，默认为克
     */
    @Column(name = "`weight`")
    @ApiModelProperty("商品重量，默认为克")
    private BigDecimal weight;

    /**
     * 是否为预告商品：0->不是；1->是
     */
    @Column(name = "`preview_status`")
    @ApiModelProperty("是否为预告商品：0->不是；1->是")
    private Integer previewStatus;

    /**
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    @Column(name = "`service_ids`")
    @ApiModelProperty("以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
    private String serviceIds;

    @Column(name = "`keywords`")
    @ApiModelProperty("")
    private String keywords;

    @Column(name = "`note`")
    @ApiModelProperty("")
    private String note;

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     */
    @Column(name = "`album_pics`")
    @ApiModelProperty("画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;

    @Column(name = "`detail_title`")
    @ApiModelProperty("")
    private String detailTitle;

    /**
     * 促销开始时间
     */
    @Column(name = "`promotion_start_time`")
    @ApiModelProperty("促销开始时间")
    private Date promotionStartTime;

    /**
     * 促销结束时间
     */
    @Column(name = "`promotion_end_time`")
    @ApiModelProperty("促销结束时间")
    private Date promotionEndTime;

    /**
     * 活动限购数量
     */
    @Column(name = "`promotion_per_limit`")
    @ApiModelProperty("活动限购数量")
    private Integer promotionPerLimit;

    /**
     * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     */
    @Column(name = "`promotion_type`")
    @ApiModelProperty("促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购")
    private Integer promotionType;

    /**
     * 品牌名称
     */
    @Column(name = "`brand_name`")
    @ApiModelProperty("品牌名称")
    private String brandName;

    /**
     * 商品分类名称
     */
    @Column(name = "`product_category_name`")
    @ApiModelProperty("商品分类名称")
    private String productCategoryName;

    /**
     * 商品描述
     */
    @Column(name = "`description`")
    @ApiModelProperty("商品描述")
    private String description;

    @Column(name = "`detail_desc`")
    @ApiModelProperty("")
    private String detailDesc;

    /**
     * 产品详情网页内容
     */
    @Column(name = "`detail_html`")
    @ApiModelProperty("产品详情网页内容")
    private String detailHtml;

    /**
     * 移动端网页详情
     */
    @Column(name = "`detail_mobile_html`")
    @ApiModelProperty("移动端网页详情")
    private String detailMobileHtml;

    private static final long serialVersionUID = 1L;
}