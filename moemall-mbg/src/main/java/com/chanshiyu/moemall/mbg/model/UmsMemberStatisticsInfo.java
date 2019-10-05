package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("会员统计信息")
@Table(name = "`ums_member_statistics_info`")
public class UmsMemberStatisticsInfo implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`member_id`")
    @ApiModelProperty("")
    private Long memberId;

    /**
     * 累计消费金额
     */
    @Column(name = "`consume_amount`")
    @ApiModelProperty("累计消费金额")
    private BigDecimal consumeAmount;

    /**
     * 订单数量
     */
    @Column(name = "`order_count`")
    @ApiModelProperty("订单数量")
    private Integer orderCount;

    /**
     * 优惠券数量
     */
    @Column(name = "`coupon_count`")
    @ApiModelProperty("优惠券数量")
    private Integer couponCount;

    /**
     * 评价数
     */
    @Column(name = "`comment_count`")
    @ApiModelProperty("评价数")
    private Integer commentCount;

    /**
     * 退货数量
     */
    @Column(name = "`return_order_count`")
    @ApiModelProperty("退货数量")
    private Integer returnOrderCount;

    /**
     * 登录次数
     */
    @Column(name = "`login_count`")
    @ApiModelProperty("登录次数")
    private Integer loginCount;

    /**
     * 关注数量
     */
    @Column(name = "`attend_count`")
    @ApiModelProperty("关注数量")
    private Integer attendCount;

    /**
     * 粉丝数量
     */
    @Column(name = "`fans_count`")
    @ApiModelProperty("粉丝数量")
    private Integer fansCount;

    @Column(name = "`collect_product_count`")
    @ApiModelProperty("")
    private Integer collectProductCount;

    @Column(name = "`collect_subject_count`")
    @ApiModelProperty("")
    private Integer collectSubjectCount;

    @Column(name = "`collect_topic_count`")
    @ApiModelProperty("")
    private Integer collectTopicCount;

    @Column(name = "`collect_comment_count`")
    @ApiModelProperty("")
    private Integer collectCommentCount;

    @Column(name = "`invite_friend_count`")
    @ApiModelProperty("")
    private Integer inviteFriendCount;

    /**
     * 最后一次下订单时间
     */
    @Column(name = "`recent_order_time`")
    @ApiModelProperty("最后一次下订单时间")
    private Date recentOrderTime;

    private static final long serialVersionUID = 1L;
}