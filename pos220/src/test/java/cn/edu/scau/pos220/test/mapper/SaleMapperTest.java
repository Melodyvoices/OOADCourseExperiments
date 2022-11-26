package cn.edu.scau.pos220.test.mapper;

import cn.edu.scau.pos220.domain.Sale;
import cn.edu.scau.pos220.domain.SaleItem;
import cn.edu.scau.pos220.mapper.SaleMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)  // 是否回滚，设为false即会更新数据库，设为true则不会更新。
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SaleMapperTest {
    @Autowired
    private SaleMapper saleMapper;

    @Test
    void selectSaleById() {
        Sale sale = saleMapper.selectSaleById(1L);
        Assert.isTrue(sale.getSaleId() == 1, "测试根据id查询");
    }

    @Test
    void selectSaleList() {
        Sale param = new Sale();
        param.setSaleNo("so-1542881137129459712");
        List<Sale> list = saleMapper.selectSaleList(param);
        Assert.hasLength("1", "测试查询list");
    }

    @Test
    void insertSale() {
        Sale sale = new Sale();
        sale.setSaleNo("test");
        sale.setTotal(BigDecimal.valueOf(100.00));
        sale.setStatus("已付款");
        Assert.isTrue(saleMapper.insertSale(sale) == 1, "测试插入");
    }

    @Test
    void updateSale() {
        Sale sale = saleMapper.selectSaleById(4L);
        sale.setDelFlag("1");
        Assert.isTrue(saleMapper.updateSale(sale) == 1, "测试更新");
    }

    @Test
    void batchInsertSaleItemOfCurrentSale() {
        List<SaleItem> saleItemList = new ArrayList<>();
        SaleItem saleItem = new SaleItem();
        saleItemList.add(saleItem);
        Assert.isTrue(saleMapper.batchInsertSaleItemOfCurrentSale(saleItemList) == 1, "");
    }
}