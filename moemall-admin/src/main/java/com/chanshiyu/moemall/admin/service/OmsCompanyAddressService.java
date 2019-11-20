package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.mbg.model.OmsCompanyAddress;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/20 15:14
 * @description 收货地址管Service
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
