package cn.edu.scau.pos220.service;


import cn.edu.scau.pos220.domain.ProductDescription;
import cn.edu.scau.pos220.domain.Sale;

import java.math.BigDecimal;

public interface ISaleService {
    /**
     * 开始新的销售
     *
     * @return
     */
    Sale makeNewSale();

    /**
     * 实例化SaleItem
     *
     * @param product  商品对象
     * @param quantity 数量
     */
    void makeLineItem(ProductDescription product, int quantity);

    /**
     * 结束订单商品录入
     *
     * @return 总金额
     */
    BigDecimal endSale();

    /**
     * 订单支付
     *
     * @param cashTendered 付款金额
     * @return 找零
     */
    BigDecimal makePayment(BigDecimal cashTendered);

    void changeQuantityOfSaleItem(String itemSn, int quantity);

    void deleteSaleItem(String itemSn);
}
