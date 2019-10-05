package com.chanshiyu.moemall.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("首页推荐专题表")
@Table(name = "`sms_home_recommend_subject`")
public class SmsHomeRecommendSubject implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("")
    private Long id;

    @Column(name = "`subject_id`")
    @ApiModelProperty("")
    private Long subjectId;

    @Column(name = "`subject_name`")
    @ApiModelProperty("")
    private String subjectName;

    @Column(name = "`recommend_status`")
    @ApiModelProperty("")
    private Integer recommendStatus;

    @Column(name = "`sort`")
    @ApiModelProperty("")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}