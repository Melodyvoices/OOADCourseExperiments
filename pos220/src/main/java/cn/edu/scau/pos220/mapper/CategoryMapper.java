package cn.edu.scau.pos220.mapper;

import cn.edu.scau.pos220.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CategoryMapper {
    @Select("SELECT category_id,category_name FROM pos_category WHERE category_id = #{categoryId}")
    public Category getCategoryById(Long categoryId);

    @Select("SELECT category_id,category_name FROM pos_category")
    public List<Category> listAllCategory();
}