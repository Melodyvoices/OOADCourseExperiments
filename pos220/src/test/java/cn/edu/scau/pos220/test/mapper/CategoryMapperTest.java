package cn.edu.scau.pos220.test.mapper;

import cn.edu.scau.pos220.domain.Category;
import cn.edu.scau.pos220.mapper.CategoryMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)   //是否回滚，设为false即会更新数据库，设为true则不会更新。
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    @Order(1)
    void getCategoryById() {
        Category p = categoryMapper.getCategoryById(1L);
        Assert.isTrue(p.getCategoryId()==1,"测试根据id查询");
    }

    @Test
    @Order(2)
    void listAllCategory() {
        List<Category> list = categoryMapper.listAllCategory();
        Assert.isTrue(list.size()==2,"测试查询所有");
    }



    @Test
    @Order(4)
    void selectCategoryList() {
        Category param = new Category();
        param.setCategoryName("文具");
        List<Category> list = categoryMapper.selectCategoryList(param);
        Assert.hasLength("2","测试查询list");
    }

    @Test
    @Order(5)
    void insertCategory() {
        Category c = new Category();
        c.setCategoryName("工具");
        c.setCategoryId(3L);
        Assert.isTrue(categoryMapper.insertCategory(c)==1,"测试插入");
    }

    @Test
    @Order(6)
    void updateCategory() {
        Category p = categoryMapper.getCategoryById(3L);
        p.setCategoryName("装修工具");
        Assert.isTrue(categoryMapper.updateCategory(p)==1,"测试更新");
    }

    @Test
    @Order(7)
    void deleteCategoryById() {
        Category p = categoryMapper.getCategoryById(3L);
        Assert.isTrue(categoryMapper.deleteCategoryById(p.getCategoryId())==1,"测试删除");
    }
}