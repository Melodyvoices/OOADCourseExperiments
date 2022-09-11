package cn.edu.scau.pos220.controller;

import cn.edu.scau.pos220.domain.Category;
import cn.edu.scau.pos220.domain.ProductDescription;
import cn.edu.scau.pos220.generator.SnGenerator;
import cn.edu.scau.pos220.query.QueryCatetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductDescription productDescription;
    @GetMapping("/{productId}")
    public ProductDescription getById(@PathVariable("productId") Long productId){
        productDescription.setProductId(productId);
        SnGenerator snCode=new SnGenerator(productId);
        productDescription.setProductSn(snCode.getSn());//use a MD5 algorithm to generate the SN code
        productDescription.setProductName("pencil");
        QueryCatetory queryCatetory=new QueryCatetory(productId);
        productDescription.setCategory(queryCatetory.getCatetory());
        productDescription.setPrice(BigDecimal.valueOf(2.00));
        return productDescription;
    }
}
