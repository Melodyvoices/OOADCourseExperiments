package cn.edu.scau.pos220.test.service;

import cn.edu.scau.pos220.domain.Category;
import cn.edu.scau.pos220.service.ICategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceImplTest {
    @Autowired
    private ICategoryService categoryService;
    @Test
    void getCategoriesById() {
        Category category=categoryService.getCategoriesById(1L);
        System.out.println(category.getCategoryName());
    }

    @Test
    void getAllCategories() {
        System.out.println(categoryService.getAllCategories());
    }
}