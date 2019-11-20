package com.chanshiyu.moemall.admin.dao;

import com.chanshiyu.moemall.admin.model.dto.OmsOrderDetail;
import com.chanshiyu.moemall.admin.model.params.OmsOrderDeliveryParam;
import com.chanshiyu.moemall.admin.model.params.OmsOrderQueryParam;
import com.chanshiyu.moemall.mbg.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/19 9:37
 * @description 订单自定义查询Dao
 */
public interface OmsOrderDao {

    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);

}
