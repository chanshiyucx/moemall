package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.model.params.PmsProductCategoryParam;
import com.chanshiyu.moemall.admin.model.params.PmsProductCategoryStatusParam;
import com.chanshiyu.moemall.admin.service.PmsProductCategoryService;
import com.chanshiyu.moemall.mbg.mapper.PmsProductCategoryAttributeRelationMapper;
import com.chanshiyu.moemall.mbg.mapper.PmsProductCategoryMapper;
import com.chanshiyu.moemall.mbg.mapper.PmsProductMapper;
import com.chanshiyu.moemall.mbg.model.PmsProduct;
import com.chanshiyu.moemall.mbg.model.PmsProductCategory;
import com.chanshiyu.moemall.mbg.model.PmsProductCategoryAttributeRelation;
import com.chanshiyu.moemall.service.vo.CommonListResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SHIYU
 * @date 2019/10/18 9:32
 * @description 商品分类Service实现类
 */
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    @Autowired
    private PmsProductMapper productMapper;

    @Autowired
    private PmsProductCategoryAttributeRelationMapper pmsProductCategoryAttributeRelationMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(pmsProductCategoryParam, productCategory);
        // 没有父分类时为一级分类
        setCategoryLevel(productCategory);
        int count = pmsProductCategoryMapper.insertSelective(productCategory);
        // 创建筛选属性关联
        List<Long> productAttributeIdList = pmsProductCategoryParam.getProductAttributeIdList();
        if (!CollectionUtils.isEmpty(productAttributeIdList)) {
            insertRelationList(productCategory.getId(), productAttributeIdList);
        }
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        BeanUtils.copyProperties(pmsProductCategoryParam, productCategory);
        setCategoryLevel(productCategory);
        // 更新商品分类时要更新商品中的名称
        PmsProduct product = new PmsProduct();
        product.setProductCategoryName(productCategory.getName());
        Example example = new Example(PmsProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productCategoryId", productCategory.getId());
        productMapper.updateByExampleSelective(product, example);
        return pmsProductCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateStatus(PmsProductCategoryStatusParam pmsProductCategoryStatusParam) {
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        BeanUtils.copyProperties(pmsProductCategoryStatusParam, pmsProductCategory);
        return pmsProductCategoryMapper.updateByPrimaryKeySelective(pmsProductCategory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(Long id) {
        return pmsProductCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommonListResult<PmsProductCategory> list(Long parentId, Integer pageNum, Integer pageSize) {
        return null;
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(PmsProductCategory productCategory) {
        // 没有父分类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            // 有父分类时选择根据父分类level设置
            PmsProductCategory parentCategory = pmsProductCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }

    /**
     * 批量插入商品分类与筛选属性关系表
     *
     * @param productCategoryId      商品分类id
     * @param productAttributeIdList 相关商品筛选属性id集合
     */
    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
        List<PmsProductCategoryAttributeRelation> relationList = productAttributeIdList.stream()
                .map(productAttrId -> {
                    PmsProductCategoryAttributeRelation relation = new PmsProductCategoryAttributeRelation();
                    relation.setProductCategoryId(productCategoryId);
                    relation.setProductAttributeId(productAttrId);
                    return relation;
                }).collect(Collectors.toList());
        pmsProductCategoryAttributeRelationMapper.insertList(relationList);
    }

}
