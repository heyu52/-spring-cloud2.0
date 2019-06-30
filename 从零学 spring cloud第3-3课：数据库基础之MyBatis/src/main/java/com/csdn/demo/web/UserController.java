package com.csdn.demo.web;

import com.csdn.demo.mapper.UserMapper;
import com.csdn.demo.mapper.UserParam;
import com.csdn.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUserById")
    public User getList(long id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @RequestMapping("/getUserByNameAndAge")
    public List<User> getUserByNameAndAge(String userSex, int userage) {
        List<User> users = userMapper.getUserByNameAndAge(userSex, userage);
        return users;
    }

    @RequestMapping("/getUserByMapParam")
    public List<User> getUserByMapParam() {

        Map param = new HashMap();
        param.put("sex", "女");
        param.put("age", 10);

        List<User> users = userMapper.getUserByMapParam(param);
        return users;
    }

    @RequestMapping("/insertUser")
    public int getList() {
        User user = new User();
        user.setName("20190630");
        user.setSex("男");
        user.setAge(99);
        userMapper.insertUser(user);
        return 1;
    }

    @RequestMapping("/updateUser")
    public int updateUser() {
        User user = new User();
        user.setId(13L);
        user.setName("201906302123");
        userMapper.updateUser(user);
        return 1;
    }

    @RequestMapping("/deleteUser")
    public int deleteUser() {
        userMapper.deleteUser(12L);
        return 1;
    }


    @RequestMapping("/updateUserByScript")
    public int updateUserByScript() {
        User user = new User();
        user.setId(13L);
        user.setName("2019");
        user.setAge(100);
        userMapper.updateUserByScript(user);
        return 1;
    }

    @RequestMapping("/getUserCount")
    public long getUserCount() {
        UserParam userParam=new UserParam();
        userParam.setUserName("csdn");
        userParam.setUserSex("男");

        long count=userMapper.getUserCount(userParam);
        return  count;
    }



}
