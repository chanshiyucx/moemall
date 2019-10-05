package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("用户举报表")
@Table(name = "`cms_member_report`")
public class CmsMemberReport implements Serializable {
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    /**
     * 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    @Column(name = "`report_type`")
    @ApiModelProperty("举报类型：0->商品评价；1->话题内容；2->用户评论")
    private Integer reportType;

    /**
     * 举报人
     */
    @Column(name = "`report_member_name`")
    @ApiModelProperty("举报人")
    private String reportMemberName;

    @Column(name = "`create_time`")
    @ApiModelProperty("")
    private Date createTime;

    @Column(name = "`report_object`")
    @ApiModelProperty("")
    private String reportObject;

    /**
     * 举报状态：0->未处理；1->已处理
     */
    @Column(name = "`report_status`")
    @ApiModelProperty("举报状态：0->未处理；1->已处理")
    private Integer reportStatus;

    /**
     * 处理结果：0->无效；1->有效；2->恶意
     */
    @Column(name = "`handle_status`")
    @ApiModelProperty("处理结果：0->无效；1->有效；2->恶意")
    private Integer handleStatus;

    @Column(name = "`note`")
    @ApiModelProperty("")
    private String note;

    private static final long serialVersionUID = 1L;
}