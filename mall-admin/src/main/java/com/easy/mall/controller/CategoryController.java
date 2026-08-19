package com.easy.mall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.easy.mall.pojo.Category;
import com.easy.mall.pojo.query.CategoryQuery;
import com.easy.mall.service.ICategoryService;
import com.easy.mall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    //Restful    GET(查找)、POST(添加)、DELETE(删除)、PUT(修改)
    //@RequestMapping("/list")
    //@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    //@RequestMapping(value = "/list", method = RequestMethod.GET)
    //@RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public Result list(CategoryQuery categoryQuery) {
        //PageInfo pageInfo = categoryService.list(categoryQuery);
        IPage<Category> page = categoryService.list(categoryQuery);
        return Result.ok(page);
    }

    // /category/deleteById?id=1
    // /category/deleteById/1
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        categoryService.removeById(id);
        return Result.ok("删除成功");
    }

    // /category/deleteById/1,2,3
    @DeleteMapping("/deleteAll/{ids}")
    public Result deleteAll(@PathVariable Integer[] ids) {
        categoryService.removeBatchByIds(Arrays.asList(ids));
        return Result.ok("删除成功");
    }

    // @RequestBody : 封装前台传递过来的JSON格式数据
    // @ResponseBody : 将数据转换为JSON格式返回
    @PostMapping("/add")
    public Result add(@RequestBody Category category) {
        categoryService.save(category);
        return Result.ok("添加成功");
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        return Result.ok(category);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Category category) {
        categoryService.updateById(category);
        return Result.ok("更新成功");
    }

    @GetMapping("/selectTopCategoeyList")
    public Result<List<Category>> selectTopCategoeyList(){
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",0);
        List<Category> categoryList = categoryService.list(queryWrapper);
        return Result.ok(categoryList);
    }

    @GetMapping("/selectSecondCategoryListByParentId/{parentId}")
    public Result<List<Category>> selectSecondCategoryListByParentId(@PathVariable Integer parentId){
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        List<Category> categoryList = categoryService.list(queryWrapper);
        return Result.ok(categoryList);
    }
}

