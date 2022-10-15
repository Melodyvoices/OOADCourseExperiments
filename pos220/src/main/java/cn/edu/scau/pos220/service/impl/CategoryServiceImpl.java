package cn.edu.scau.pos220.service.impl;

import cn.edu.scau.pos220.core.domain.Category;
import cn.edu.scau.pos220.mapper.ProductCatalog;
import cn.edu.scau.pos220.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ProductCatalog productCatalog;

    @Override
    public Category getCategoriesById(Long categoryId) {
        return productCatalog.getCategoriesById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return productCatalog.listAllCategories();
    }
}
