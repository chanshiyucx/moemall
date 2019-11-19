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

    /**
     * 批量修改商品上架状态
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改新品状态
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 批量修改审核状态
     */
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

}
