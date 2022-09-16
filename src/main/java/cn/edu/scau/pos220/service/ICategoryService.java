package cn.edu.scau.pos220.service;

import cn.edu.scau.pos220.core.domain.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoriesById(Long categoryId);

    List<Category> listAllCategories();
}
