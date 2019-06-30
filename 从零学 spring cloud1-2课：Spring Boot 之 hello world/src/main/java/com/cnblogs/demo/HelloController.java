package com.cnblogs.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/hello2")
    public String hello(String name) {
        return "hello  " + name;
    }

}
