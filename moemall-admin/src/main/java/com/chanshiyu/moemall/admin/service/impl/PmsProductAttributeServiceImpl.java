package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.service.PmsProductAttributeService;
import com.chanshiyu.moemall.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.chanshiyu.moemall.mbg.mapper.PmsProductAttributeMapper;
import com.chanshiyu.moemall.mbg.model.PmsProductAttribute;
import com.chanshiyu.moemall.mbg.model.PmsProductAttributeCategory;
import com.chanshiyu.moemall.service.vo.CommonListResult;
import com.chanshiyu.moemall.service.vo.ResultAttributes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/11/12 15:05
 * @description 商品属性Service实现类
 */
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;

    @Autowired
    private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(PmsProductAttribute pmsProductAttribute) {
        int count = pmsProductAttributeMapper.insertSelective(pmsProductAttribute);
        // 需要更新商品属性分类表中的数量, 0 属性，1 参数
        PmsProductAttributeCategory pmsProductAttributeCategory = pmsProductAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        if (pmsProductAttribute.getType() == 0) {
            pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount() + 1);
        } else if (pmsProductAttribute.getType() == 1) {
            pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount() + 1);
        }
        pmsProductAttributeCategoryMapper.updateByPrimaryKey(pmsProductAttributeCategory);
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(PmsProductAttribute pmsProductAttribute) {
        return pmsProductAttributeMapper.updateByPrimaryKeySelective(pmsProductAttribute);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(Long id) {
        // 需要更新商品属性分类表中的数量, 0 属性，1 参数，注意先获取再删除
        PmsProductAttribute pmsProductAttribute = pmsProductAttributeMapper.selectByPrimaryKey(id);
        int count = pmsProductAttributeMapper.deleteByPrimaryKey(id);
        PmsProductAttributeCategory pmsProductAttributeCategory = pmsProductAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        if (pmsProductAttribute.getType() == 0) {
            pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount() - 1);
        } else if (pmsProductAttribute.getType() == 1) {
            pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount() - 1);
        }
        pmsProductAttributeCategoryMapper.updateByPrimaryKey(pmsProductAttributeCategory);
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommonListResult<PmsProductAttribute> list(Integer pageNum, Integer pageSize, Long cid, Integer type) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(PmsProductAttribute.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productAttributeCategoryId", cid);
        criteria.andEqualTo("type", type);
        List<PmsProductAttribute> list = pmsProductAttributeMapper.selectByExample(example);
        PageInfo<PmsProductAttribute> info = new PageInfo<>(list);
        ResultAttributes resultAttributes = new ResultAttributes(info.getPageNum(), info.getPageSize(), info.getTotal());
        return new CommonListResult<>(list, resultAttributes);
    }
}
