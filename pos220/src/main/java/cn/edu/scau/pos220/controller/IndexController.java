package cn.edu.scau.pos220.controller;

import cn.edu.scau.pos220.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//a Restful style controller
@RestController
public class IndexController {
    @GetMapping("/")
    public AjaxResult index(){
        String data = "Hello SpringBoot";
        return AjaxResult.success("ok",data);
    }
}
