package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/16 8:59
 * @description 商品品牌Service
 */
public interface PmsBrandService {

    /**
     * 新增品牌
     */
    int create(PmsBrand pmsBrand);

    /**
     * 更新品牌
     */
    int update(PmsBrand pmsBrand);

    /**
     * 删除品牌
     */
    int delete(Long id);

    /**
     * 获取品牌列表
     */
    List<PmsBrand> list();

}
