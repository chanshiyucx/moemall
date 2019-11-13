package com.chanshiyu.moemall.admin.dao;

import com.chanshiyu.moemall.admin.model.dto.ProductAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/13 15:10
 * @description
 */
public interface ProductAttributeDao {

    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);

}
