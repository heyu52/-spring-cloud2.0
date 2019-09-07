package com.csdn.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/MyActuator")
    public  String MyActuator()
    {
        return  "hello world";
    }

}
