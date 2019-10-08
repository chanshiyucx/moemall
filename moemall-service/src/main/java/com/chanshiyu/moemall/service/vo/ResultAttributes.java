package com.chanshiyu.moemall.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author SHIYU
 * @date 2019/8/29 9:18
 * @description 分页描述信息
 */
@Data
@AllArgsConstructor
public class ResultAttributes {

    /** 当前页数 */
    private Integer pageNum;

    /** 页大小 */
    private Integer pageSize;

    /** 总数 */
    private Long total;

}