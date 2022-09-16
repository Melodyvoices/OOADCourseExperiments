package cn.edu.scau.pos220.service;

import cn.edu.scau.pos220.core.domain.ProductDescription;

import java.util.List;

public interface IProductService {
    ProductDescription getProductBySn(String productSn);
    List<ProductDescription> getAllProducts();
}
