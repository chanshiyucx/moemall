package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.mbg.model.PmsProductAttributeCategory;
import com.chanshiyu.moemall.service.vo.CommonListResult;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/12 16:28
 * @description 商品属性分类Service
 */
public interface PmsProductAttributeCategoryService {

    int create(String name);

    int update(Long id, String name);

    int delete(Long id);

    CommonListResult<PmsProductAttributeCategory> list(Integer pageNum, Integer pageSize);

}
