package com.easy.mall.controller;


import com.easy.mall.pojo.Admin;
import com.easy.mall.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author niu
 * @since 2026-08-10
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/list")
    public List<Admin> list(){
        List<Admin> list = adminService.list();
        return list;
    }

}

