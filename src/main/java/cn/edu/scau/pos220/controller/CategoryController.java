package cn.edu.scau.pos220.controller;

import cn.edu.scau.pos220.core.domain.Category;
import cn.edu.scau.pos220.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private Category category;

    @GetMapping("/{categoryId}")
    public Category getById(@PathVariable("categoryId") Long categoryID) {
        category=new CategoryServiceImpl().getCategoriesById(categoryID);
        return category;
    }

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return new CategoryServiceImpl().listAllCategories();
    }
}
