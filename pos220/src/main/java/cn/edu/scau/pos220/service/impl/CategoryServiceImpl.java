package cn.edu.scau.pos220.service.impl;

import cn.edu.scau.pos220.domain.Category;
import cn.edu.scau.pos220.mapper.CategoryMapper;
import cn.edu.scau.pos220.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Category getCategoriesById(Long categoryId) {
        return categoryMapper.getCategoryById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.listAllCategory();
    }

    @Override
    public List<Category> selectCategoryList(Category category) {
        return categoryMapper.selectCategoryList(category);
    }

    @Override
    public int insertCategory(Category category) {
        category.setCreateTime(new Date());
        return categoryMapper.insertCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        category.setUpdateTime(new Date());
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategoryById(Long categoryId) {
        return categoryMapper.deleteCategoryById(categoryId);
    }
}
