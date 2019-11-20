package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.service.OmsOrderSettingService;
import com.chanshiyu.moemall.mbg.mapper.OmsOrderSettingMapper;
import com.chanshiyu.moemall.mbg.model.OmsOrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author SHIYU
 * @date 2019/11/20 14:36
 * @description
 */
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public OmsOrderSetting getItem(Long id) {
        return orderSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int update(Long id, OmsOrderSetting orderSetting) {
        orderSetting.setId(id);
        return orderSettingMapper.updateByPrimaryKey(orderSetting);
    }
}
