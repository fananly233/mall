package com.easy.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.easy.mall.pojo.Product;
import com.easy.mall.pojo.query.ProductQuery;
import com.easy.mall.pojo.vo.ProductVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author niu
 * @since 2026-08-10
 */
public interface ProductMapper extends BaseMapper<Product> {

    IPage<ProductVO> list(IPage<ProductVO> page, ProductQuery productQuery);
}
