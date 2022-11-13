package cn.edu.scau.pos220.test.service;

import cn.edu.scau.pos220.domain.ProductDescription;
import cn.edu.scau.pos220.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private IProductService productService;

    @Test
    void getProductBySn() {
        ProductDescription product = productService.getProductBySn("1001");
        System.out.println(product.getProductName());
    }

    @Test
    void listAllProduct() {
        System.out.println(productService.getAllProducts());
    }

}