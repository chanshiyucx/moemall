package com.chanshiyu.moemall.admin.model.dto;

import com.chanshiyu.moemall.mbg.model.OmsOrder;
import com.chanshiyu.moemall.mbg.model.OmsOrderItem;
import com.chanshiyu.moemall.mbg.model.OmsOrderOperateHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/19 9:39
 * @description 订单详情信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OmsOrderDetail extends OmsOrder {

    private List<OmsOrderItem> orderItemList;

    private List<OmsOrderOperateHistory> historyList;

}
