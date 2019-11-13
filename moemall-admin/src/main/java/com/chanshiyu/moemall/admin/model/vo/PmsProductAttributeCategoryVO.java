package com.chanshiyu.moemall.admin.model.vo;

import com.chanshiyu.moemall.mbg.model.PmsProductAttribute;
import com.chanshiyu.moemall.mbg.model.PmsProductAttributeCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/13 9:49
 * @description 商品属性分类及其属性
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsProductAttributeCategoryVO extends PmsProductAttributeCategory {

    private List<PmsProductAttribute> productAttributeList;

}
