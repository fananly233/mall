package com.easy.mall.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.easy.mall.pojo.Product;
import com.easy.mall.pojo.query.ProductQuery;
import com.easy.mall.pojo.vo.ProductVO;
import com.easy.mall.service.IProductService;
import com.easy.mall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author niu
 * @since 2026-08-10
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    //Restful    GET(查找)、POST(添加)、DELETE(删除)、PUT(修改)
    //@RequestMapping("/list")
    //@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    //@RequestMapping(value = "/list", method = RequestMethod.GET)
    //@RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public Result list(ProductQuery productQuery) {
        //PageInfo pageInfo = productService.list(productQuery);
        IPage<ProductVO> page = productService.list(productQuery);
        return Result.ok(page);
    }

    // /product/deleteById?id=1
    // /product/deleteById/1
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        productService.removeById(id);
        return Result.ok("删除成功");
    }

    // /product/deleteById/1,2,3
    @DeleteMapping("/deleteAll/{ids}")
    public Result deleteAll(@PathVariable Integer[] ids) {
        productService.removeBatchByIds(Arrays.asList(ids));
        return Result.ok("删除成功");
    }

    // @RequestBody : 封装前台传递过来的JSON格式数据
    // @ResponseBody : 将数据转换为JSON格式返回
    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        productService.save(product);
        return Result.ok("添加成功");
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Product product = productService.getById(id);
        return Result.ok(product);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Product product) {
        productService.updateById(product);
        return Result.ok("更新成功");
    }
}

