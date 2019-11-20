package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.mbg.model.OmsOrderSetting;

/**
 * @author SHIYU
 * @date 2019/11/20 14:35
 * @description 订单设置Service
 */
public interface OmsOrderSettingService {

    /**
     * 获取指定订单设置
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     */
    int update(Long id, OmsOrderSetting orderSetting);

}
