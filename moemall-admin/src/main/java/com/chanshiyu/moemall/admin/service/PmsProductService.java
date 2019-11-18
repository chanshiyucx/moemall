package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.params.PmsProductCategoryParam;
import com.chanshiyu.moemall.admin.model.params.PmsProductParam;
import com.chanshiyu.moemall.mbg.model.PmsProduct;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/18 11:18
 * @description 商品Service
 */
public interface PmsProductService {

    /**
     * 新增商品
     */
    int create(PmsProductParam pmsProductParam);

    /**
     * 更新商品
     */
    int update(PmsProductParam pmsProductParam);

    /**
     * 分页查询商品
     */
    List<PmsProduct> list(Integer pageSize, Integer pageNum);

}
