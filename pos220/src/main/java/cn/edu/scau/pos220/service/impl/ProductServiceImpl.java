package cn.edu.scau.pos220.service.impl;

import cn.edu.scau.pos220.domain.ProductDescription;
import cn.edu.scau.pos220.mapper.ProductMapper;
import cn.edu.scau.pos220.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDescription getProductBySn(String productSn) {
        return productMapper.getProductBySn(productSn);
    }

    @Override
    public List<ProductDescription> getAllProducts() {
        return productMapper.listAllProduct();
    }

    @Override
    public ProductDescription selectProductById(Long productId) {
        return productMapper.selectProductById(productId);
    }

    @Override
    public List<ProductDescription> selectProductList(ProductDescription productDescription) {
        return productMapper.selectProductList(productDescription);
    }

    @Override
    public int insertProduct(ProductDescription productDescription) {
        productDescription.setCreateTime(new Date());
        return productMapper.insertProduct(productDescription);
    }

    @Override
    public int updateProduct(ProductDescription productDescription) {
        productDescription.setUpdateTime(new Date());
        return productMapper.updateProduct(productDescription);
    }

    @Override
    public int deleteProductById(Long productId) {
        return productMapper.deleteProductById(productId);
    }
}
