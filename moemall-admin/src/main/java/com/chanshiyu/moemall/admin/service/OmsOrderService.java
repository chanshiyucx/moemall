package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.dto.OmsOrderDetail;
import com.chanshiyu.moemall.admin.model.params.OmsMoneyInfoParam;
import com.chanshiyu.moemall.admin.model.params.OmsOrderDeliveryParam;
import com.chanshiyu.moemall.admin.model.params.OmsOrderQueryParam;
import com.chanshiyu.moemall.admin.model.params.OmsReceiverInfoParam;
import com.chanshiyu.moemall.mbg.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/19 9:31
 * @description 订单管理Service
 */
public interface OmsOrderService {

    /**
     * 订单查询
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量发货
     */
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     */
    int close(List<Long> ids, String note);

    /**
     * 批量删除订单
     */
    int delete(List<Long> ids);

    /**
     * 获取指定订单详情
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     */
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
     */
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     */
    int updateNote(Long id, String note, Integer status);

}
