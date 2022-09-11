package cn.edu.scau.pos220.query;

import cn.edu.scau.pos220.domain.Category;

public class QueryCatetory {
    public QueryCatetory(){}

    private Long productID;

    public QueryCatetory(Long productID){
        this.productID=productID;
    }

    public Category category=new Category();
    public Category getCatetory(){
        category.setCategoryId(1001L);
        category.setCategoryName("stationery");
        //emulate the process of querying the database

        return category;
    }
}
