package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.service.OmsCompanyAddressService;
import com.chanshiyu.moemall.mbg.mapper.OmsCompanyAddressMapper;
import com.chanshiyu.moemall.mbg.model.OmsCompanyAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/20 15:14
 * @description 收货地址管理Service实现类
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectAll();
    }
}
