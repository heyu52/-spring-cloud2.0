package com.csdn.demo.web;

import com.csdn.demo.Repository.UserRepository;
import com.csdn.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/CreateUser")
    public String CreateUser() {
        userRepository.save(new User("csdn20190714", "男", 100));
        return "创建成功";
    }


    @RequestMapping("/FindUserById")
    public ArrayList<User> FindUserById(long id) {
        ArrayList<User> users = new ArrayList<User>();
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            users.add(user);
        } else {

        }
        return users;
    }


    @RequestMapping("/findByName")
    public ArrayList<User> findByName(String name) {
        return userRepository.findByName(name);
    }

}
