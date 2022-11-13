package cn.edu.scau.pos220.mapper;

import cn.edu.scau.pos220.domain.ProductDescription;

import java.util.List;

public interface ProductMapper {
    public ProductDescription getProductBySn(String productSn);

    public List<ProductDescription> listAllProduct();

    public ProductDescription selectProductById(Long productId);

    public List<ProductDescription> selectProductList(ProductDescription productDescription);

    public int insertProduct(ProductDescription productDescription);

    public int updateProduct(ProductDescription productDescription);

    public int deleteProductById(Long productId);
}