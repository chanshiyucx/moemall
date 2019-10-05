package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("会员表")
@Table(name = "`ums_member`")
public class UmsMember implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`member_level_id`")
    @ApiModelProperty("")
    private Long memberLevelId;

    /**
     * 用户名
     */
    @Column(name = "`username`")
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    @ApiModelProperty("密码")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "`nickname`")
    @ApiModelProperty("昵称")
    private String nickname;

    /**
     * 手机号码
     */
    @Column(name = "`phone`")
    @ApiModelProperty("手机号码")
    private String phone;

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    @Column(name = "`status`")
    @ApiModelProperty("帐号启用状态:0->禁用；1->启用")
    private Integer status;

    /**
     * 注册时间
     */
    @Column(name = "`create_time`")
    @ApiModelProperty("注册时间")
    private Date createTime;

    /**
     * 头像
     */
    @Column(name = "`icon`")
    @ApiModelProperty("头像")
    private String icon;

    /**
     * 性别：0->未知；1->男；2->女
     */
    @Column(name = "`gender`")
    @ApiModelProperty("性别：0->未知；1->男；2->女")
    private Integer gender;

    /**
     * 生日
     */
    @Column(name = "`birthday`")
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * 所做城市
     */
    @Column(name = "`city`")
    @ApiModelProperty("所做城市")
    private String city;

    /**
     * 职业
     */
    @Column(name = "`job`")
    @ApiModelProperty("职业")
    private String job;

    /**
     * 个性签名
     */
    @Column(name = "`personalized_signature`")
    @ApiModelProperty("个性签名")
    private String personalizedSignature;

    /**
     * 用户来源
     */
    @Column(name = "`source_type`")
    @ApiModelProperty("用户来源")
    private Integer sourceType;

    /**
     * 积分
     */
    @Column(name = "`integration`")
    @ApiModelProperty("积分")
    private Integer integration;

    /**
     * 成长值
     */
    @Column(name = "`growth`")
    @ApiModelProperty("成长值")
    private Integer growth;

    /**
     * 剩余抽奖次数
     */
    @Column(name = "`luckey_count`")
    @ApiModelProperty("剩余抽奖次数")
    private Integer luckeyCount;

    /**
     * 历史积分数量
     */
    @Column(name = "`history_integration`")
    @ApiModelProperty("历史积分数量")
    private Integer historyIntegration;

    private static final long serialVersionUID = 1L;
}