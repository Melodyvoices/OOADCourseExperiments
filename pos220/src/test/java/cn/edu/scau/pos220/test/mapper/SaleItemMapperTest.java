package cn.edu.scau.pos220.test.mapper;

import cn.edu.scau.pos220.domain.Sale;
import cn.edu.scau.pos220.domain.SaleItem;
import cn.edu.scau.pos220.mapper.SaleItemMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)  // 是否回滚，设为false即会更新数据库，设为true则不会更新。
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SaleItemMapperTest {
    @Autowired
    private SaleItemMapper saleItemMapper;

    @Test
    void selectSaleItemById() {
        SaleItem saleItem=saleItemMapper.selectSaleItemById(1L);
        Assert.isTrue(saleItem.getSaleItemId()==1,"测试根据id查询");
    }

    @Test
    void selectSaleItemList() {
        SaleItem param=new SaleItem();
        param.setPrice(BigDecimal.valueOf(30.00));
        List<SaleItem> list = saleItemMapper.selectSaleItemList(param);
        Assert.hasLength("2","测试查询list");
    }

    @Test
    void insertSaleItem() {
        SaleItem saleItem = new SaleItem();
        saleItem.setProductId(1L);
        Assert.isTrue(saleItemMapper.insertSaleItem(saleItem)==1,"测试插入");
    }

    @Test
    void updateSaleItem() {
        SaleItem saleItem=saleItemMapper.selectSaleItemById(9L);
        saleItem.setDelFlag("1");
        Assert.isTrue(saleItemMapper.updateSaleItem(saleItem)==1,"测试更新");
    }
}