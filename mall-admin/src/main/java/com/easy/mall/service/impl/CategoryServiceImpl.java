package com.easy.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.mall.mapper.CategoryMapper;
import com.easy.mall.pojo.Category;
import com.easy.mall.pojo.query.CategoryQuery;
import com.easy.mall.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public IPage<Category> list(CategoryQuery categoryQuery) {
        IPage<Category> page = new Page<>(categoryQuery.getPage(), categoryQuery.getLimit());
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!ObjectUtils.isEmpty(categoryQuery.getName()), "name", categoryQuery.getName());
        categoryMapper.selectPage(page, queryWrapper);
        return page;
    }
}
