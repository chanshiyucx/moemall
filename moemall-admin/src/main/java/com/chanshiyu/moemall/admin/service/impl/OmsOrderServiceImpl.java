package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.dao.OmsOrderDao;
import com.chanshiyu.moemall.admin.model.dto.OmsOrderDetail;
import com.chanshiyu.moemall.admin.model.params.OmsMoneyInfoParam;
import com.chanshiyu.moemall.admin.model.params.OmsOrderDeliveryParam;
import com.chanshiyu.moemall.admin.model.params.OmsOrderQueryParam;
import com.chanshiyu.moemall.admin.model.params.OmsReceiverInfoParam;
import com.chanshiyu.moemall.admin.service.OmsOrderService;
import com.chanshiyu.moemall.mbg.mapper.OmsOrderMapper;
import com.chanshiyu.moemall.mbg.mapper.OmsOrderOperateHistoryMapper;
import com.chanshiyu.moemall.mbg.model.OmsOrder;
import com.chanshiyu.moemall.mbg.model.OmsOrderOperateHistory;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SHIYU
 * @date 2019/11/19 9:36
 * @description
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    private OmsOrderDao orderDao;

    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        // 批量发货
        int count = orderDao.delivery(deliveryParamList);
        // 添加操作记录
        List<OmsOrderOperateHistory> operateHistoryList = deliveryParamList.stream()
                .map(omsOrderDeliveryParam -> {
                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                    history.setOrderId(omsOrderDeliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        omsOrderOperateHistoryMapper.insertList(operateHistoryList);
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int close(List<Long> ids, String note) {
        OmsOrder record = new OmsOrder();
        record.setStatus(4);
        Example example = new Example(OmsOrder.class);
        example.createCriteria()
                .andEqualTo("deleteStatus", 0)
                .andIn("id", ids);
        int count = omsOrderMapper.updateByExampleSelective(record, example);
        List<OmsOrderOperateHistory> historyList = ids.stream().map(orderId -> {
            OmsOrderOperateHistory history = new OmsOrderOperateHistory();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(4);
            history.setNote("订单关闭:" + note);
            return history;
        }).collect(Collectors.toList());
        omsOrderOperateHistoryMapper.insertList(historyList);
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(List<Long> ids) {
        OmsOrder record = new OmsOrder();
        record.setDeleteStatus(1);
        Example example = new Example(OmsOrder.class);
        example.createCriteria()
                .andEqualTo("deleteStatus", 0)
                .andIn("id", ids);
        return omsOrderMapper.updateByExampleSelective(record, example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public OmsOrderDetail detail(Long id) {
        return orderDao.getDetail(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(receiverInfoParam, order);
        order.setId(receiverInfoParam.getOrderId());
        order.setReceiverName(receiverInfoParam.getReceiverName());
        order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
        order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
        order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
        order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
        order.setReceiverCity(receiverInfoParam.getReceiverCity());
        order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
        order.setModifyTime(new Date());
        int count = omsOrderMapper.updateByPrimaryKeySelective(order);
        // 插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(receiverInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(receiverInfoParam.getStatus());
        history.setNote("修改收货人信息");
        omsOrderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam) {
        OmsOrder order = new OmsOrder();
        order.setId(moneyInfoParam.getOrderId());
        order.setFreightAmount(moneyInfoParam.getFreightAmount());
        order.setDiscountAmount(moneyInfoParam.getDiscountAmount());
        order.setModifyTime(new Date());
        int count = omsOrderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(moneyInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(moneyInfoParam.getStatus());
        history.setNote("修改费用信息");
        omsOrderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateNote(Long id, String note, Integer status) {
        OmsOrder order = new OmsOrder();
        order.setId(id);
        order.setNote(note);
        order.setModifyTime(new Date());
        int count = omsOrderMapper.updateByPrimaryKeySelective(order);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息：" + note);
        omsOrderOperateHistoryMapper.insert(history);
        return count;
    }

}
