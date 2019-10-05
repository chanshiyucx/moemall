package com.chanshiyu.moemall.mbg.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms_home_recommend_subject")
public class SmsHomeRecommendSubject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    private Integer sort;

    private static final long serialVersionUID = 1L;
}