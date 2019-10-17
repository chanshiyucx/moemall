package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.params.PmsBrandParam;
import com.chanshiyu.moemall.admin.model.params.PmsBrandStatusParam;
import com.chanshiyu.moemall.mbg.model.PmsBrand;
import com.chanshiyu.moemall.service.vo.CommonListResult;

/**
 * @author SHIYU
 * @date 2019/10/16 8:59
 * @description 商品品牌Service
 */
public interface PmsBrandService {

    /**
     * 新增品牌
     */
    int create(PmsBrandParam pmsBrandParam);

    /**
     * 更新品牌
     */
    int update(PmsBrandParam pmsBrandParam);

    /**
     * 更新品牌状态
     */
    int updateStatus(PmsBrandStatusParam pmsBrandStatusParam);

    /**
     * 删除品牌
     */
    int delete(Long id);

    /**
     * 获取品牌列表
     */
    CommonListResult<PmsBrand> list(Integer pageNum, Integer pageSize, String name);

}
