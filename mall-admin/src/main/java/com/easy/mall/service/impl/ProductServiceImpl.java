package com.easy.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.mall.mapper.ProductMapper;
import com.easy.mall.pojo.Product;
import com.easy.mall.pojo.query.ProductQuery;
import com.easy.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author niu
 * @since 2026-08-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<Product> list(ProductQuery productQuery) {
        IPage<Product> page = new Page<>(productQuery.getPage(), productQuery.getLimit());
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!ObjectUtils.isEmpty(productQuery.getName()), "name", productQuery.getName());
        productMapper.selectPage(page, queryWrapper);
        return page;
    }
}
