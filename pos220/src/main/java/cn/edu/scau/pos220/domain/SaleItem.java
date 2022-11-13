package cn.edu.scau.pos220.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleItem implements Serializable {
    private Long saleItemId;
    private ProductDescription productDescription;
    private int quantity;

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
     * @return 小计
     */
    public BigDecimal getSubTotal(){
        BigDecimal subTotal =  productDescription.getPrice().multiply(new BigDecimal(quantity));
        return subTotal;
    }


}
