package cn.edu.scau.pos220.controller;

import cn.edu.scau.pos220.core.domain.ProductDescription;
import cn.edu.scau.pos220.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductDescription productDescription;

    @GetMapping("/{productSn}")
    public ProductDescription getById(@PathVariable("productSn") Long productSn) {
        productDescription= new ProductServiceImpl().getProductBySn(productSn.toString());
        return productDescription;
    }
    @GetMapping("/all")
    public List<ProductDescription> getAllProducts(){
        return new ProductServiceImpl().getAllProducts();
    }
}
