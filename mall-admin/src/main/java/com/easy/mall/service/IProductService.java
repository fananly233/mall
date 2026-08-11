package com.easy.mall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.mall.pojo.Product;
import com.easy.mall.pojo.query.ProductQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author niu
 * @since 2026-08-10
 */
public interface IProductService extends IService<Product> {

    IPage<Product> list(ProductQuery productQuery);
}
