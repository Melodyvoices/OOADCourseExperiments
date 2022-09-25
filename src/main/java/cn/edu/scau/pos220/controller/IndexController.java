package cn.edu.scau.pos220.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//a Restful style controller
@RestController
public class IndexController {
    //interface
    @GetMapping
    @ApiOperation("a start page")
    public String index() {
        return "Hello SpringBoot!";
    }
}
