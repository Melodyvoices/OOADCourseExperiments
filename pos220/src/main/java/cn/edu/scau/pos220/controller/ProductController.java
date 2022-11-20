package cn.edu.scau.pos220.controller;

import cn.edu.scau.pos220.core.domain.AjaxResult;
import cn.edu.scau.pos220.domain.ProductDescription;
import cn.edu.scau.pos220.service.IProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/getBySn/{productSn}")
    @ApiOperation("根据SN找产品")
    public AjaxResult getBySn(@PathVariable("productSn") String productSn){
        return AjaxResult.success(productService.getProductBySn(productSn));
    }

    @GetMapping("/all")
    @ApiOperation("列出所有产品")
    public AjaxResult listAll(){
        return AjaxResult.success(productService.getAllProducts());
    }

    @GetMapping("/list")
    @ApiOperation("查询产品列表")
    public AjaxResult list(ProductDescription product) {
        List<ProductDescription> list = productService.selectProductList(product);
        return AjaxResult.success(list);
    }

    @GetMapping(value = "/{productId}")
    @ApiOperation("查询产品详情")
    public AjaxResult get(@PathVariable("productId") Long productId) {
        return AjaxResult.success(productService.selectProductById(productId));
    }

    @PostMapping
    @ApiOperation("新增产品")
    public AjaxResult add(@RequestBody ProductDescription product) {
        int rows = productService.insertProduct(product);
        return rows > 0 ? AjaxResult.success("添加产品成功") : AjaxResult.error("添加产品失败");
    }

    @PutMapping
    @ApiOperation("修改产品")
    public AjaxResult edit(@RequestBody ProductDescription product) {
        int rows = productService.updateProduct(product);
        return rows > 0 ? AjaxResult.success("修改产品成功") : AjaxResult.error("修改产品失败");
    }

    @DeleteMapping("/{productId}")
    @ApiOperation("删除产品")
    public AjaxResult remove(@PathVariable Long productId) {
        int rows = productService.deleteProductById(productId);
        return rows > 0 ? AjaxResult.success("删除产品成功") : AjaxResult.error("删除产品失败");
    }

    //restful style use "get" to receive data
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public AjaxResult page(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, ProductDescription product) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductDescription> list = productService.selectProductList(product);
        PageInfo<List> pageInfo = new PageInfo(list);
        // 以下写法也可以
        // PageInfo<ProductDescription> pageInfo = new PageInfo<>(list)
        return AjaxResult.success(pageInfo);
    }
}