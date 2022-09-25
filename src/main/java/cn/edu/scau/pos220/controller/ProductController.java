package cn.edu.scau.pos220.controller;

import cn.edu.scau.pos220.core.constants.HttpStatus;
import cn.edu.scau.pos220.core.domain.AjaxResult;
import cn.edu.scau.pos220.core.domain.ProductDescription;
import cn.edu.scau.pos220.service.IProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/{productSn}")
    @ApiOperation("get the product's information by its sn code")
    public AjaxResult getBySn(@PathVariable("productSn") String productSn) {
        try {
            ProductDescription p = productService.getProductBySn(productSn);
            if (p == null) {
                return AjaxResult.error(HttpStatus.BAD_REQUEST.value(),"未查询到相关信息");
            }
            else {
                return AjaxResult.success(productService.getProductBySn(productSn));
            }
        } catch (Exception e) {
            return AjaxResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @GetMapping("/all")
    @ApiOperation("get all products' information")
    public AjaxResult listAll() {
        return AjaxResult.success(productService.getAllProducts());
    }
}
