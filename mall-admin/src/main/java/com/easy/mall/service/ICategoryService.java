package com.easy.mall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.mall.pojo.Category;
import com.easy.mall.pojo.query.CategoryQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author niu
 * @since 2026-08-10
 */
public interface ICategoryService extends IService<Category> {

    IPage<Category> list(CategoryQuery categoryQuery);
}
