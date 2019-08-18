package com.csdn.demo.web;

import com.csdn.demo.Repository.UserRepository;
import com.csdn.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("SaveUser")
    public String SaveUser() throws Exception {
        User user=new User();
        user.setId(3l);
        user.setUserName("csdn");
        userRepository.saveUser(user);
        return  "创建用户成功";
    }

    @RequestMapping("deleteUserById")
    public String deleteUserById(){
        userRepository.deleteUserById(2L);
        return  "删除用户成功";
    }

    @RequestMapping("updateUser")
    public String updateUser(){
        User user=new User();
        user.setId(1l);
        user.setUserName("csdn001");
        userRepository.updateUser(user);
        return  "更新用户成功";
    }

    @RequestMapping("findUserByUserName")
    public String findUserByUserName(){
        User user= userRepository.findUserByUserName("csdn");
       return  user.toString();
    }

}
