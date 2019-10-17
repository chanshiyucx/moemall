package com.chanshiyu.moemall.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.chanshiyu.moemall.admin.model.params.PmsBrandParam;
import com.chanshiyu.moemall.admin.model.params.PmsBrandStatusParam;
import com.chanshiyu.moemall.admin.service.PmsBrandService;
import com.chanshiyu.moemall.mbg.mapper.PmsBrandMapper;
import com.chanshiyu.moemall.mbg.mapper.PmsProductMapper;
import com.chanshiyu.moemall.mbg.model.PmsBrand;
import com.chanshiyu.moemall.mbg.model.PmsProduct;
import com.chanshiyu.moemall.service.vo.CommonListResult;
import com.chanshiyu.moemall.service.vo.ResultAttributes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/16 9:01
 * @description 商品品牌Service实现类
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        pmsBrand.setCreateTime(new Date());
        // 如果创建时首字母为空，取名称的第一个为首字母
        if (StrUtil.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        // 如果创建时首字母为空，取名称的第一个为首字母
        if (StrUtil.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        // 更新品牌时要更新商品中的品牌名称
        PmsProduct product = new PmsProduct();
        product.setBrandName(pmsBrand.getName());
        Example example = new Example(PmsProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("brandId", pmsBrand.getId());
        pmsProductMapper.updateByExampleSelective(product, example);
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateStatus(PmsBrandStatusParam pmsBrandStatusParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandStatusParam, pmsBrand);
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommonListResult<PmsBrand> list(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(PmsBrand.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        List<PmsBrand> pmsBrandList = pmsBrandMapper.selectByExample(example);
        PageInfo<PmsBrand> info = new PageInfo<>(pmsBrandList);
        ResultAttributes attributes = new ResultAttributes(info.getPageNum(), info.getPageSize(), info.getTotal());
        return new CommonListResult<>(pmsBrandList, attributes);
    }

}
