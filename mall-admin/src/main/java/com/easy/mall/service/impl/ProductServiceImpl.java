package com.easy.mall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.mall.mapper.ProductMapper;
import com.easy.mall.pojo.Product;
import com.easy.mall.pojo.query.ProductQuery;
import com.easy.mall.pojo.vo.ProductVO;
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
    public IPage<ProductVO> list(ProductQuery productQuery) {
        IPage<ProductVO> page = new Page<>(productQuery.getPage(), productQuery.getLimit());

        productMapper.list(page, productQuery);
        return page;
    }
}
