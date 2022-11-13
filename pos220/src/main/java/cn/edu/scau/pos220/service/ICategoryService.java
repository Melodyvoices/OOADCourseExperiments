package cn.edu.scau.pos220.service;

import cn.edu.scau.pos220.domain.Category;
import cn.edu.scau.pos220.domain.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoriesById(Long categoryId);

    List<Category> getAllCategories();

    public List<Category> selectCategoryList(Category category);

    public int insertCategory(Category category);

    public int updateCategory(Category category);

    public int deleteCategoryById(Long categoryId);
}
