package com.csdn.GoodsPO.web;

import com.csdn.GoodsPO.RestfulRemote.GoodsPRRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @Autowired
    GoodsPRRemote goodsPRRemote;

    @RequestMapping("/home")
    public String home() {
        return "这是订单服务";
    }


    @RequestMapping("/getGoodspr")
    public String getGoodspr(@RequestParam(value = "name", defaultValue = "csdn") String name) {
        return goodsPRRemote.home(name);
    }


}
