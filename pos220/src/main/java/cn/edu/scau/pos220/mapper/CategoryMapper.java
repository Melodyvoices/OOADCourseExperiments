package cn.edu.scau.pos220.mapper;

import cn.edu.scau.pos220.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CategoryMapper {
    public Category getCategoryById(Long categoryId);

    public List<Category> listAllCategory();

    public List<Category> selectCategoryList(Category category);

    public int insertCategory(Category category);

    public int updateCategory(Category category);

    public int deleteCategoryById(Long categoryId);
}