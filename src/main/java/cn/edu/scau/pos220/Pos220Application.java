package cn.edu.scau.pos220;

import cn.edu.scau.pos220.mapper.ProductCatalog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pos220Application {

    public static void main(String[] args) {
        SpringApplication.run(Pos220Application.class, args);
        //System.out.println(SpringBootVersion.getVersion());
    }

}
