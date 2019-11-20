package com.chanshiyu.moemall.admin.dao;

import com.chanshiyu.moemall.admin.model.dto.OmsOrderReturnApplyResult;
import com.chanshiyu.moemall.admin.model.params.OmsReturnApplyQueryParam;
import com.chanshiyu.moemall.mbg.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/20 14:47
 * @description 订单退货申请自定义Dao
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
