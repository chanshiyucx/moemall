package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.dao.PmsProductAttributeCategoryDao;
import com.chanshiyu.moemall.admin.model.vo.PmsProductAttributeCategoryVO;
import com.chanshiyu.moemall.admin.service.PmsProductAttributeCategoryService;
import com.chanshiyu.moemall.mbg.mapper.PmsProductAttributeCategoryMapper;
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
 * @date 2019/11/12 16:31
 * @description 商品属性分类Service实现类
 */
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {

    @Autowired
    private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;

    @Autowired
    private PmsProductAttributeCategoryDao pmsProductAttributeCategoryDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(String name) {
        PmsProductAttributeCategory pmsProductAttributeCategory = new PmsProductAttributeCategory();
        pmsProductAttributeCategory.setName(name);
        pmsProductAttributeCategory.setAttributeCount(0);
        pmsProductAttributeCategory.setParamCount(0);
        return pmsProductAttributeCategoryMapper.insertSelective(pmsProductAttributeCategory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(Long id, String name) {
        // 只更新名称
        PmsProductAttributeCategory pmsProductAttributeCategory = new PmsProductAttributeCategory();
        pmsProductAttributeCategory.setId(id);
        pmsProductAttributeCategory.setName(name);
        return pmsProductAttributeCategoryMapper.updateByPrimaryKeySelective(pmsProductAttributeCategory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(Long id) {
        return pmsProductAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommonListResult<PmsProductAttributeCategory> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(PmsProductAttributeCategory.class);
        List<PmsProductAttributeCategory> list = pmsProductAttributeCategoryMapper.selectByExample(example);
        PageInfo<PmsProductAttributeCategory> info = new PageInfo<>(list);
        ResultAttributes resultAttributes = new ResultAttributes(info.getPageNum(), info.getPageSize(), info.getTotal());
        return new CommonListResult<>(list, resultAttributes);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<PmsProductAttributeCategoryVO> listWithAttr() {
        return pmsProductAttributeCategoryDao.listWithAttr();
    }
}
