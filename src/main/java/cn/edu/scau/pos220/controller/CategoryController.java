package cn.edu.scau.pos220.controller;

import cn.edu.scau.pos220.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private Category category;
    @GetMapping("/{categoryId}")
    public Category getById(@PathVariable("categoryId") Long categoryID){
        category.setCategoryId(categoryID);
        category.setCategoryName("stationery");
        return  category;
    }
}
