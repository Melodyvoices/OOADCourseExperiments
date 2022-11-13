package cn.edu.scau.pos220.domain;

import cn.edu.scau.pos220.core.domain.BaseEntity;
import org.springframework.stereotype.Component;

/**
 * product category
 * standard POJO class
 */
@Component
public class Category extends BaseEntity {
    private Long categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(long categoryId, String categoryName) {
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }

    //setter n getter
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    //test console
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
