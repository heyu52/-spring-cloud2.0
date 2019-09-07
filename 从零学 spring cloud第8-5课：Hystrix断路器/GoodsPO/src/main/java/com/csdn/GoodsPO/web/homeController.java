package com.csdn.GoodsPO.web;

import com.csdn.GoodsPO.RestfulRemote.GoodsPRRemote;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class homeController {

    @Autowired
    GoodsPRRemote goodsPRRemote;
    private final Random rnd = new Random(System.currentTimeMillis());

    @RequestMapping("/home")
    public String home() {
        return "这是订单服务";
    }


    @RequestMapping("/getGoodspr")
    public String getGoodspr(@RequestParam(value = "name", defaultValue = "csdn") String name) {
        return goodsPRRemote.home(name);
    }


    @GetMapping("/findOrder/{orderNo}")
    @HystrixCommand(fallbackMethod = "findOrderFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String findOrder(@PathVariable String orderNo)  throws InterruptedException  {

        Thread.sleep(rnd.nextInt(2000));

        return "订单" + orderNo + " 找到啦！";

    }

    public String findOrderFallback(String orderNo) {
        return "订单查找失败！";
    }

}
