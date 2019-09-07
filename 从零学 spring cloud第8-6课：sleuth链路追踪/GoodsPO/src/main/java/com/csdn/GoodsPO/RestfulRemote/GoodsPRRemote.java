package com.csdn.GoodsPO.RestfulRemote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "GOODSPR")
public interface GoodsPRRemote {
    //restful api 调用
    @GetMapping("/home/{name}")
    public String home(@PathVariable("name") String name);
}
