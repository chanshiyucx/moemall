package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.service.OmsOrderReturnReasonService;
import com.chanshiyu.moemall.mbg.mapper.OmsOrderReturnReasonMapper;
import com.chanshiyu.moemall.mbg.model.OmsOrderReturnReason;
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
 * @date 2019/11/20 14:38
 * @description
 */
@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {
    @Autowired
    private OmsOrderReturnReasonMapper returnReasonMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(OmsOrderReturnReason returnReason) {
        returnReason.setCreateTime(new Date());
        return returnReasonMapper.insert(returnReason);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(Long id, OmsOrderReturnReason returnReason) {
        returnReason.setId(id);
        return returnReasonMapper.updateByPrimaryKey(returnReason);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(List<Long> ids) {
        Example example = new Example(OmsOrderReturnReason.class);
        example.createCriteria().andIn("id", ids);
        return returnReasonMapper.deleteByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(OmsOrderReturnReason.class);
        example.setOrderByClause("sort desc");
        return returnReasonMapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateStatus(List<Long> ids, Integer status) {
        if (!status.equals(0) && !status.equals(1)) {
            return 0;
        }
        OmsOrderReturnReason record = new OmsOrderReturnReason();
        record.setStatus(status);
        Example example = new Example(OmsOrderReturnReason.class);
        example.createCriteria().andIn("id", ids);
        return returnReasonMapper.updateByExampleSelective(record, example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public OmsOrderReturnReason getItem(Long id) {
        return returnReasonMapper.selectByPrimaryKey(id);
    }
}
