package cn.edu.scau.pos220.domain;

import cn.edu.scau.pos220.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * product description
 * POJO class
 */
public class ProductDescription extends BaseEntity {
    public ProductDescription(){}

    public ProductDescription(Long productId, String productSn, Category category, String productName, BigDecimal price) {
        this.productId = productId;
        this.productSn = productSn;
        this.category = category;
        this.productName = productName;
        this.price = price;
    }

    private Long productId;

    private String productSn;

    private Long categoryId;
    private Category category;

    private String productName;

    private BigDecimal price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDescription{" +
                "productId=" + productId +
                ", productSn='" + productSn + '\'' +
                ", category=" + category +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}