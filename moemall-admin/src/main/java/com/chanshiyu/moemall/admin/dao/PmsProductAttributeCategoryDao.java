package com.chanshiyu.moemall.admin.dao;

import com.chanshiyu.moemall.admin.model.vo.PmsProductAttributeCategoryVO;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/13 9:50
 * @description 商品属性分类Dao
 */
public interface PmsProductAttributeCategoryDao {

    List<PmsProductAttributeCategoryVO> listWithAttr();

}
