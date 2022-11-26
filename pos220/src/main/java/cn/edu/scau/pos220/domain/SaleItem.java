package cn.edu.scau.pos220.domain;

import cn.edu.scau.pos220.core.domain.BaseEntity;

import java.math.BigDecimal;

public class SaleItem extends BaseEntity {
    private Long saleItemId;
    private ProductDescription productDescription;
    private int quantity;
    private Long saleId;
    private Long productId;
    private BigDecimal price; // 销售价格(等于product的price)
    private String status;
    private String delFlag;

    // Setter和Getter

    public Long getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(Long saleItemId) {
        this.saleItemId = saleItemId;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * 计算小计
     *
     * @return 小计
     */
    public BigDecimal getSubTotal() {
        BigDecimal subTotal = productDescription.getPrice().multiply(new BigDecimal(quantity));
        return subTotal;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
