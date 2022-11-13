package cn.edu.scau.pos220.controller;

import cn.edu.scau.pos220.domain.ProductDescription;
import cn.edu.scau.pos220.mapper.ProductCatalog;
import cn.edu.scau.pos220.service.ISaleService;
import cn.edu.scau.pos220.view.vo.SaleItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 记账本
 * GRASP:控制器
 */
@Component
public class Register {
    @Autowired
    private ISaleService saleService;

    @Autowired
    private ProductCatalog productCatalog;

    /**
     * 开始一次新的销售
     */
    public void makeNewSale(){
        saleService.makeNewSale();

    }
    /**
     * 输入商品
     * @param itemSn 产品编号
     * @param quantity 数量
     */
    public SaleItemVo enterItem(String itemSn, int quantity){
        SaleItemVo saleItemVo = null;
        ProductDescription product = productCatalog.getProductBySn(itemSn);
        if(product != null) {
            saleService.makeLineItem(product, quantity);
            saleItemVo = new SaleItemVo(itemSn, product.getProductName(), product.getPrice(), quantity);
        }
        return saleItemVo;
    }
    /**
     * 结束销售
     */
    public BigDecimal endSale(){
        return saleService.endSale();
    }
    /**
     * 确认支付
     * @param cashTendered 支付金额
     */
    public BigDecimal makePayment(BigDecimal cashTendered){
        return saleService.makePayment(cashTendered);
    }
}
