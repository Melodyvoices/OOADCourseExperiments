package cn.edu.scau.pos220.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//a Restful style controller
@RestController
public class IndexController {
    //interface
    @GetMapping
    public String index(){
        return "Hello SpringBoot!";
    }
}
