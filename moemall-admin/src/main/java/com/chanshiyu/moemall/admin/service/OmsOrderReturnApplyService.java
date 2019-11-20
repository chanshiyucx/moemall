package com.chanshiyu.moemall.admin.service;

import com.chanshiyu.moemall.admin.model.dto.OmsOrderReturnApplyResult;
import com.chanshiyu.moemall.admin.model.params.OmsReturnApplyQueryParam;
import com.chanshiyu.moemall.admin.model.params.OmsUpdateStatusParam;
import com.chanshiyu.moemall.mbg.model.OmsOrderReturnApply;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/20 14:41
 * @description 退货申请管理Service
 */
public interface OmsOrderReturnApplyService {

    /**
     * 分页查询申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     */
    int delete(List<Long> ids);

    /**
     * 修改申请状态
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApplyResult getItem(Long id);

}
