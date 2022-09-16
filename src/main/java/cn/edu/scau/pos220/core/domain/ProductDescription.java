package cn.edu.scau.pos220.core.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * product description
 * POJO class
 */
@Component
public class ProductDescription {
    public ProductDescription() {
    }

    private Long productId;
    private String productSn;
    private Category category;
    private String productName;
    private BigDecimal price;

    public ProductDescription(Long productId, String productSn, Category category, String productName, BigDecimal price) {
        this.productId = productId;
        this.productSn = productSn;
        this.category = category;
        this.productName = productName;
        this.price = price;
    }


    //setter n getter
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

    //test console
    @Override
    public String toString() {
        return "Category{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productSn='" + productSn + '\'' +
                "price=" + price +
                "category=" + category +
                '}';
    }
}
