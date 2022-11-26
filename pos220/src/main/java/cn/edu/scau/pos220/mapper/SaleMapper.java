package cn.edu.scau.pos220.mapper;

import cn.edu.scau.pos220.domain.Sale;
import cn.edu.scau.pos220.domain.SaleItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface SaleMapper {
    /**
     *根据id查询订单对象
     * @param saleId
     * @return
     */
    public Sale selectSaleById(Long saleId);

    /**
     *查询订单列表
     * @param sale
     * @return
     */
    public List<Sale> selectSaleList(Sale sale);

    /**
     *新增订单对象
     * @param sale
     * @return
     */
    public int insertSale(Sale sale);

    /**
     *更新订单对象
     * @param sale
     * @return
     */
    public int updateSale(Sale sale);

    /**
     *批量新增订单明细
     * @param saleItemList
     * @return
     */
    public int batchInsertSaleItemOfCurrentSale(List<SaleItem> saleItemList);
}
