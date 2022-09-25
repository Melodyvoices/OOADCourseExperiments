package cn.edu.scau.pos220.controller;


import cn.edu.scau.pos220.core.constants.HttpStatus;
import cn.edu.scau.pos220.core.domain.AjaxResult;
import cn.edu.scau.pos220.core.domain.Category;
import cn.edu.scau.pos220.core.domain.ProductDescription;
import cn.edu.scau.pos220.service.ICategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/{categoryId}")
    @ApiOperation("get the category's information by its id")
    public AjaxResult getBySn(@PathVariable("categoryId") String categoryId) {
        Long id;
        try {
            id = Long.valueOf(categoryId);
        }catch (Exception e){
            return AjaxResult.error(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value(),"输入格式错误");
        }
        try {
            Category p = categoryService.getCategoriesById(id);
            if (p == null) {
                return AjaxResult.error(HttpStatus.BAD_REQUEST.value(),"未查询到相关信息");
            }
            else {
                return AjaxResult.success(categoryService.getCategoriesById(id));
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
}
