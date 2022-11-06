package cn.edu.scau.pos220.service.impl;

import cn.edu.scau.pos220.core.domain.ProductDescription;
import cn.edu.scau.pos220.mapper.ProductMapper;
import cn.edu.scau.pos220.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return productMapper.getAllProducts();
    }
}
