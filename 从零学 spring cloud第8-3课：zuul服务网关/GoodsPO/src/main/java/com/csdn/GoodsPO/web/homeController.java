package com.csdn.GoodsPO.web;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @RequestMapping("/home")
    public  String home()
    {
        return  "这是订单服务";
    }

}
