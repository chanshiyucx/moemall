package com.chanshiyu.moemall.admin.model.dto;

import com.chanshiyu.moemall.mbg.model.OmsCompanyAddress;
import com.chanshiyu.moemall.mbg.model.OmsOrderReturnApply;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author SHIYU
 * @date 2019/11/20 14:43
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    private OmsCompanyAddress companyAddress;
}
