package com.csdn.demo.web;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableCaching
@RestController
public class MyController {

    @Cacheable(value = "MyCacheMethod")
    @RequestMapping("/MyCacheMethod")
    public String MyCacheMethod(String key) {
        System.out.println("MyCacheMethod 没有走缓存！");
        return "MyCacheMethod" + key;
    }

    //condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持 SpEL。
    @RequestMapping("/ConditionCacheMethod")
    @Cacheable(value = "ConditionCacheMethod", condition = "#key.length() <= 4")
    public String ConditionCacheMethod(String key) {
        System.out.println(key + " 没有走缓存！");
        return "ConditionCacheMethod" + key;
    }

    //与 @Cacheable 不同的是使用 @CachePut 标注的方法在执行前，不会去检查缓存中是否存在之前执行过的结果，
    // 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
    @RequestMapping("/CachePutMyCacheMethod")
    @CachePut(value = "MyCacheMethod", key = "#key")
    public String CachePutMyCacheMethod(String key) {
        System.out.println(key + " 更新缓存数据！");
        return "CachePutMyCacheMethod" + key;
    }


    //allEntries 是 boolean 类型，表示是否需要清除缓存中的所有元素，默认为 false，表示不需要。
    // 当指定了 allEntries 为 true 时，Spring Cache 将忽略指定的 key，
    // 有的时候我们需要 Cache 一下清除所有的元素，这比一个一个清除元素更有效率。
    @RequestMapping("/allEntriesMyCacheMethod")
    @CacheEvict(value = "MyCacheMethod", allEntries = true)
    public String allEntriesMyCacheMethod() {
        return "MyCacheMethod 清理缓存成功";
    }


    //清除操作默认是在对应方法成功执行之后触发的，即方法如果因为抛出异常而未能成功返回时也不会触发清除操作。
    // 使用 beforeInvocation 可以改变触发清除操作的时间，
    // 当我们指定该属性值为 true 时，Spring 会在调用该方法之前清除缓存中的指定元素。
    @RequestMapping("/beforeInvocation")
    @CacheEvict(value = "MyCacheMethod", allEntries = true, beforeInvocation = true)
    public void beforeInvocation() {
        throw new RuntimeException("test beforeInvocation");
    }


}

