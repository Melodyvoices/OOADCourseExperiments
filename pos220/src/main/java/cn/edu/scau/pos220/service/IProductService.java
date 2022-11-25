package cn.edu.scau.pos220.service;

import cn.edu.scau.pos220.domain.ProductDescription;

import java.util.List;

public interface IProductService {
    ProductDescription getProductBySn(String productSn);
    List<ProductDescription> getAllProducts();
    public ProductDescription selectProductById(Long productId);

    public List<ProductDescription> selectProductList(ProductDescription productDescription);

    public int insertProduct(ProductDescription productDescription);

    public int updateProduct(ProductDescription productDescription);

    public int deleteProductById(Long productId);

    public int deleteProductsByIds(Long[] productIds);
}
