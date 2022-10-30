package cn.edu.scau.pos220.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 数据表格模型
 *
 */
public class SaleItemVo implements Serializable {
    private String itemSn;
    private String productName;
    private BigDecimal price;
    private int quantity;

    public SaleItemVo(){}

    public SaleItemVo(String itemSn, String productName, BigDecimal price, int quantity) {
        this.itemSn = itemSn;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    //省略Setter和Getter

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
