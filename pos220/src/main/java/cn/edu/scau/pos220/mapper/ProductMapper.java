package cn.edu.scau.pos220.mapper;

import cn.edu.scau.pos220.core.domain.ProductDescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM pos_product WHERE product_sn = #{productSn}")
    public ProductDescription getProductBySn(String productSn);

    @Select("SELECT * FROM pos_product")
    public List<ProductDescription> getAllProducts();
}