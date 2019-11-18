package com.chanshiyu.moemall.admin.service.impl;

import com.chanshiyu.moemall.admin.model.params.PmsProductParam;
import com.chanshiyu.moemall.admin.service.PmsProductService;
import com.chanshiyu.moemall.mbg.mapper.*;
import com.chanshiyu.moemall.mbg.model.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.MyMapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SHIYU
 * @date 2019/11/18 11:20
 * @description
 */
@Service
public class PmsProductServiceImpl implements PmsProductService {

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Autowired
    private PmsMemberPriceMapper pmsMemberPriceMapper;

    @Autowired
    private PmsProductLadderMapper pmsProductLadderMapper;

    @Autowired
    private PmsProductFullReductionMapper pmsProductFullReductionMapper;

    @Autowired
    private PmsSkuStockMapper pmsSkuStockMapper;

    @Autowired
    private PmsProductAttributeValueMapper pmsProductAttributeValueMapper;

    @Autowired
    private CmsSubjectCategoryMapper cmsSubjectCategoryMapper;

    @Autowired
    private CmsPrefrenceAreaProductRelationMapper cmsPrefrenceAreaProductRelationMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(PmsProductParam pmsProductParam) {
        // 创建商品
        PmsProduct pmsProduct = new PmsProduct();
        BeanUtils.copyProperties(pmsProductParam, pmsProduct);
        pmsProduct.setId(null);
        int count = pmsProductMapper.insertSelective(pmsProduct);
        // 回显商品ID
        Long productId = pmsProduct.getId();
        // 1. 根据促销类型设置价格：会员价格、阶梯价格、满减价格
        // 会员价格
        relateAndInsertList(pmsMemberPriceMapper, pmsProductParam.getMemberPriceList(), productId);
        // 阶梯价格
        relateAndInsertList(pmsProductLadderMapper, pmsProductParam.getProductLadderList(), productId);
        // 满减价格
        relateAndInsertList(pmsProductFullReductionMapper, pmsProductParam.getProductFullReductionList(), productId);
        // 2. 添加sku库存信息
        // 处理sku的编码
        handleSkuStockCode(pmsProductParam.getSkuStockList(), productId);
        // 添加sku库存信息
        relateAndInsertList(pmsSkuStockMapper, pmsProductParam.getSkuStockList(), productId);
        // 3. 添加商品参数,添加自定义商品规格
        relateAndInsertList(pmsProductAttributeValueMapper, pmsProductParam.getProductAttributeValueList(), productId);
        // 4. 关联专题
        relateAndInsertList(cmsSubjectCategoryMapper, pmsProductParam.getSubjectProductRelationList(), productId);
        // 5. 关联优选
        relateAndInsertList(cmsPrefrenceAreaProductRelationMapper, pmsProductParam.getPrefrenceAreaProductRelationList(), productId);
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(PmsProductParam pmsProductParam) {
        // 更新商品信息
        PmsProduct pmsProduct = new PmsProduct();
        BeanUtils.copyProperties(pmsProductParam, pmsProduct);
        int count = pmsProductMapper.updateByPrimaryKeySelective(pmsProduct);
        Long productId = pmsProduct.getId();
        // 1. 根据促销类型设置价格：会员价格、阶梯价格、满减价格
        // 会员价格
        Example pmsMemberPriceExample = new Example(PmsMemberPrice.class);
        pmsMemberPriceExample.createCriteria().andEqualTo("productId", productId);
        pmsMemberPriceMapper.deleteByExample(pmsMemberPriceExample);
        relateAndInsertList(pmsMemberPriceMapper, pmsProductParam.getMemberPriceList(), productId);
        // 阶梯价格
        Example ladderExample = new Example(PmsProductLadder.class);
        ladderExample.createCriteria().andEqualTo("productId", productId);
        pmsProductLadderMapper.deleteByExample(ladderExample);
        relateAndInsertList(pmsProductLadderMapper, pmsProductParam.getProductLadderList(), productId);
        // 满减价格
        Example fullReductionExample = new Example(PmsProductFullReduction.class);
        fullReductionExample.createCriteria().andEqualTo("productId", productId);
        pmsProductFullReductionMapper.deleteByExample(fullReductionExample);
        relateAndInsertList(pmsProductFullReductionMapper, pmsProductParam.getProductFullReductionList(), productId);
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<PmsProduct> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        Example productExample = new Example(PmsProduct.class);
        Example.Criteria criteria = productExample.createCriteria();
        criteria.andEqualTo("deleteStatus", 0);
        return pmsProductMapper.selectByExample(productExample);
    }

    /**
     * 建立和插入关系
     *
     * @param dataList  要插入的数据
     * @param productId 建立关系的 id
     */
    private void relateAndInsertList(MyMapper mapper, List dataList, Long productId) {
        try {
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            mapper.insertList(dataList);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 处理sku的编码
     *
     * @param skuStockList
     * @param productId
     */
    private void handleSkuStockCode(List<PmsSkuStock> skuStockList, Long productId) {
        if (CollectionUtils.isEmpty(skuStockList)) return;
        for (int i = 0; i < skuStockList.size(); i++) {
            PmsSkuStock skuStock = skuStockList.get(i);
            if (StringUtils.isEmpty(skuStock.getSkuCode())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                // 生成 id，结构类似 201806070023001
                StringBuilder sb = new StringBuilder();
                // 日期
                sb.append(sdf.format(new Date()));
                // 四位商品id
                sb.append(String.format("%04d", productId));
                // 三位索引id
                sb.append(String.format("%03d", i + 1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }
}
