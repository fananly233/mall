package com.easy.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.mall.mapper.AdminMapper;
import com.easy.mall.pojo.Admin;
import com.easy.mall.pojo.query.AdminQuery;
import com.easy.mall.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public IPage<Admin> list(AdminQuery adminQuery) {
        //记录开始时间
//        long begin = System.currentTimeMillis();

        IPage<Admin> page = new Page<>(adminQuery.getPage(), adminQuery.getLimit());
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!ObjectUtils.isEmpty(adminQuery.getName()), "name", adminQuery.getName());
        queryWrapper.like(!ObjectUtils.isEmpty(adminQuery.getEmail()), "email", adminQuery.getEmail());
        adminMapper.selectPage(page, queryWrapper);

        /*Thread thread = new Thread();

        try {
            thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        long end = System.currentTimeMillis();
        long duration = end - begin;


        if(duration > 3000){
            logger.error("AdminServiceImpl.list()方法执行时间过长，耗时：" + duration + "毫秒");
        }else if(duration > 2000){
            logger.warn("AdminServiceImpl.list()方法执行时间较长，耗时：" + duration + "毫秒");
        }else{
            logger.info("AdminServiceImpl.list()方法执行时间：" + duration + "毫秒");
        }*/

        return page;
    }

}
