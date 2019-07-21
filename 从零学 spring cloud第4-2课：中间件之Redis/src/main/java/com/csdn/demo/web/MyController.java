package com.csdn.demo.web;

import com.csdn.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
public class MyController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/GetString")
    public String GetStringByKey(String key) {
        return redisTemplate.opsForValue().get(key).toString();
    }

    @RequestMapping("/SetStringByKey")
    public void SetStringByKey(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @RequestMapping("/SetObjByKey")
    public void SetObjByKey() {
        User user = new User("csdn001", "2019");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("csdn001", user);
    }

    @RequestMapping("/GetObjByKey")
    public User GetObjByKey() {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        User user = operations.get("csdn001");
        return user;
    }


    @RequestMapping("/DeleteObjByKey")
    public String DeleteObjByKey() {
        redisTemplate.delete("csdn001");
        return "删除成功";
    }


    @RequestMapping("/SetExpireObjByKey")
    public void SetExpireObjByKey() {
        User user = new User("csdn001", "2019");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("csdn001", user, 100, TimeUnit.MILLISECONDS);
    }

    @RequestMapping("/SetHashObjByKey")
    public void SetHashObjByKey() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put("hash001", "field001", "value001");
        hash.put("hash001", "field002", "value002");
        hash.put("hash002", "field001", "value003");
    }

    @RequestMapping("/GetHashObjByKey")
    public String GetHashObjByKey() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get("hash001", "field001").toString();

    }

    @RequestMapping("/SetListObjByKey")
    public void SetListObjByKey() {
        ListOperations<String, String> list = redisTemplate.opsForList();
        list.leftPush("list001", "1");
        list.leftPush("list001", "2");
        list.leftPush("list001", "3");

       /* String value=(String)list.leftPop("list001");
        System.out.println("list value :"+value.toString());

        value=(String)list.rightPop("list001");
        System.out.println("list value :"+value.toString());*/
    }

    @RequestMapping("/GetListObjByRange")
    public void GetListObjByRange() {
        ListOperations<String, String> list = redisTemplate.opsForList();
        List<String> values = list.range("list001", 1, 2);
        for (String v : values) {
            System.out.println(v);
        }
    }

    @RequestMapping("SetMSetObj")
    public void SetMSetObj() {
        String key = "csdnSet001";
        SetOperations<String, String> set = redisTemplate.opsForSet();
        set.add(key, "2");
        set.add(key, "0");
        set.add(key, "6");
        set.add(key, "5");
        set.add(key, "2");
        set.add(key, "3");
        set.add(key, "6");
        set.add(key, "6");
        Set<String> values = set.members(key);

        for (String v : values) {
            System.out.println("set value :" + v);
        }

    }

    @RequestMapping("/SetDifferenceObj")
    public void SetDifferenceObj() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key1 = "key1";
        String key2 = "key2";
        set.add(key1, "1");
        set.add(key1, "2");
        set.add(key1, "3");
        set.add(key1, "4");
        set.add(key2, "5");
        set.add(key2, "4");

        //第一个集合中的元素在第二个集合中不存在
        Set<String> diffs = set.difference(key1, key2);
        for (String v : diffs) {
            System.out.println("diffs set value :" + v);
        }
    }

    @RequestMapping("/SetUnionObj")
    public void SetUnionObj() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key1 = "key1";
        String key2 = "key2";

        Set<String> alls = set.union(key1, key2);
        for (String v : alls) {
            System.out.println("All value :" + v);
        }
    }

    @RequestMapping("/SetOrderObj")
    public void SetOrderObj(){
        String key="csdn201907";
        redisTemplate.delete(key);
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.add(key,"key001",3);
        zset.add(key,"key002",2);
        zset.add(key,"key003",1);
        zset.add(key,"key004",4);

        Set<String> zsets=zset.range(key,0,3);
        for (String v:zsets){
            System.out.println("zset value :"+v);
        }

        Set<String> zsetB=zset.rangeByScore(key,0,3);
        for (String v:zsetB){
            System.out.println("zsetB value :"+v);
        }
    }

}