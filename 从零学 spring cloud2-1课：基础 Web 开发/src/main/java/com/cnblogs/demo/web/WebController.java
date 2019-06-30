package com.cnblogs.demo.web;

import com.cnblogs.demo.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @RequestMapping(name = "/getUser")
    public User getUser() {
        User user = new User();
        user.setName("csdn");
        user.setAge(20);
        user.setSex("男");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setName("csdn001");
        user1.setAge(10);
        user1.setSex("男");
        users.add(user1);

        User user2 = new User();
        user2.setName("csdn002");
        user2.setAge(20);
        user2.setSex("男");
        users.add(user2);
        return users;
    }

    @RequestMapping(name = "/getUserName", method = RequestMethod.GET)
    public String getUserName(String name) {
        return "这是我传入的参数:" + name;
    }

    @RequestMapping(value = "getName/{name}", method = RequestMethod.GET)
    public String get(@PathVariable String name) {
        return "这是我传入的参数:" + name;
    }

}