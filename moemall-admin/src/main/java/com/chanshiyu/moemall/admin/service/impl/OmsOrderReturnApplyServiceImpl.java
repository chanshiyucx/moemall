package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.dao.OmsOrderReturnApplyDao;
import com.chanshiyu.moemall.admin.model.dto.OmsOrderReturnApplyResult;
import com.chanshiyu.moemall.admin.model.params.OmsReturnApplyQueryParam;
import com.chanshiyu.moemall.admin.model.params.OmsUpdateStatusParam;
import com.chanshiyu.moemall.admin.service.OmsOrderReturnApplyService;
import com.chanshiyu.moemall.mbg.mapper.OmsOrderReturnApplyMapper;
import com.chanshiyu.moemall.mbg.model.OmsOrderReturnApply;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/20 14:44
 * @description 订单退货管理Service
 */
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;

    @Autowired
    private OmsOrderReturnApplyDao returnApplyDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return returnApplyDao.getList(queryParam);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(List<Long> ids) {
        Example example = new Example(OmsOrderReturnApply.class);
        example.createCriteria()
                .andIn("id", ids)
                .andEqualTo("status", 3);
        return returnApplyMapper.deleteByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateStatus(Long id, OmsUpdateStatusParam statusParam) {
        Integer status = statusParam.getStatus();
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        if (status.equals(1)) {
            // 确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        } else if (status.equals(2)) {
            // 完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        } else if (status.equals(3)) {
            // 拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        } else {
            return 0;
        }
        return returnApplyMapper.updateByPrimaryKeySelective(returnApply);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public OmsOrderReturnApplyResult getItem(Long id) {
        return returnApplyDao.getDetail(id);
    }
}
