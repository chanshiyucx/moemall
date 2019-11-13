package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.dto.ProductAttrInfo;
import com.chanshiyu.moemall.mbg.model.PmsProductAttribute;
import com.chanshiyu.moemall.service.vo.CommonListResult;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/12 14:51
 * @description 商品属性Service
 */
public interface PmsProductAttributeService {

    /**
     * 新增属性
     */
    int create(PmsProductAttribute pmsProductAttribute);

    /**
     * 更新品牌
     */
    int update(PmsProductAttribute pmsProductAttribute);

    /**
     * 删除属性
     */
    int delete(Long id);

    /**
     * 获取属性列表
     */
    CommonListResult<PmsProductAttribute> list(Integer pageNum, Integer pageSize, Long cid, Integer type);


    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
