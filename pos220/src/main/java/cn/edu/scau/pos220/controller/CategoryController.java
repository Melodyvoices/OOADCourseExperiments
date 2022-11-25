package cn.edu.scau.pos220.controller;


import cn.edu.scau.pos220.core.constants.HttpStatus;
import cn.edu.scau.pos220.core.domain.AjaxResult;
import cn.edu.scau.pos220.domain.Category;
import cn.edu.scau.pos220.domain.Category;
import cn.edu.scau.pos220.domain.ProductDescription;
import cn.edu.scau.pos220.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/{id}")
    @ApiOperation("get the category's information by its id")
    public AjaxResult getById(@PathVariable("id") String id) {
        Long categoryId;
        try {
            categoryId = Long.valueOf(id);
        }catch (Exception e){
            return AjaxResult.error(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value(),"输入格式错误");
        }
        try {
            Category c = categoryService.getCategoriesById(categoryId);
            if (c == null) {
                return AjaxResult.error(HttpStatus.BAD_REQUEST.value(),"未查询到相关信息");
            }
            else {
                return AjaxResult.success(c);
            }
        } catch (Exception e) {
            return AjaxResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @GetMapping("/all")
    @ApiOperation("get all categories' information")
    public AjaxResult listAll() {
        return AjaxResult.success(categoryService.getAllCategories());
    }

    @GetMapping("/list")
    @ApiOperation("查询种类列表")
    public AjaxResult list(Category category) {
        List<Category> list = categoryService.selectCategoryList(category);
        return AjaxResult.success(list);
    }



    @PostMapping
    @ApiOperation("新增种类")
    public AjaxResult add(@RequestBody Category category) {
        int rows = categoryService.insertCategory(category);
        return rows > 0 ? AjaxResult.success("添加种类成功") : AjaxResult.error("添加种类失败");
    }

    @PutMapping
    @ApiOperation("修改种类")
    public AjaxResult edit(@RequestBody Category category) {
        int rows = categoryService.updateCategory(category);
        return rows > 0 ? AjaxResult.success("修改种类成功") : AjaxResult.error("修改种类失败");
    }

    @DeleteMapping("/{categoryId}")
    @ApiOperation("删除种类")
    public AjaxResult remove(@PathVariable Long categoryId) {
        int rows = categoryService.deleteCategoryById(categoryId);
        return rows > 0 ? AjaxResult.success("删除种类成功") : AjaxResult.error("删除种类失败");
    }

    //restful style use "get" to receive data
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public AjaxResult page(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, Category category) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> list = categoryService.selectCategoryList(category);
        PageInfo<List> pageInfo = new PageInfo(list);
        // 以下写法也可以
        // PageInfo<ProductDescription> pageInfo = new PageInfo<>(list)
        return AjaxResult.success(pageInfo);
    }
}
