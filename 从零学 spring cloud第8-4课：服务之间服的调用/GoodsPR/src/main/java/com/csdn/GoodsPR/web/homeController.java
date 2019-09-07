package com.csdn.GoodsPR.web;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @RequestMapping("/home/{name}")
    public  String home(@RequestParam(value = "name", defaultValue = "csdn") String name)
    {
        return  "这是需求服务"+"参数:"+name;
    }
}
