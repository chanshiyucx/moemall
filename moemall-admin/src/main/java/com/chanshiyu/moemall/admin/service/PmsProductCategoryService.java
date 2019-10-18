package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.params.PmsProductCategoryParam;
import com.chanshiyu.moemall.admin.model.params.PmsProductCategoryStatusParam;
import com.chanshiyu.moemall.mbg.model.PmsProductCategory;
import com.chanshiyu.moemall.service.vo.CommonListResult;

/**
 * @author SHIYU
 * @date 2019/10/18 9:03
 * @description 商品分类Service
 */
public interface PmsProductCategoryService {

    /**
     * 新增分类
     */
    int create(PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * 更新分类
     */
    int update(PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * 更新分类状态
     */
    int updateStatus(PmsProductCategoryStatusParam pmsProductCategoryStatusParam);

    /**
     * 删除分类
     */
    int delete(Long id);

    /**
     * 获取分类列表
     */
    CommonListResult<PmsProductCategory> list(Long parentId, Integer pageNum, Integer pageSize);

}
