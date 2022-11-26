package cn.edu.scau.pos220.mapper;

import cn.edu.scau.pos220.domain.SaleItem;

import java.util.List;

public interface SaleItemMapper {

    /**
     *根据id查询订单明细对象
     * @param saleItemId
     * @return
     */
    public SaleItem selectSaleItemById(Long saleItemId);

    /**
     *查询订单明细列表
     * @param saleItem
     * @return
     */
    public List<SaleItem> selectSaleItemList(SaleItem saleItem);

    /**
     *新增订单明细对象
     * @param saleItem
     * @return
     */
    public int insertSaleItem(SaleItem saleItem);

    /**
     * 更新订单对象
     * @param saleItem
     * @return
     */
    public int updateSaleItem(SaleItem saleItem);

}