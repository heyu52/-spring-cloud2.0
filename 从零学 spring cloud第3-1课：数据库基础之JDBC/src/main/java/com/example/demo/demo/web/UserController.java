package com.example.demo.demo.web;

import com.example.demo.demo.Repository.UserRepository;
import com.example.demo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/CreateUser")
    public int CreateUser() {
        User user = new User("csdn", "男", 18);
        return userRepository.save(user);
    }


    @RequestMapping("/findById")
    public User findById(long id) {
        return userRepository.findById(id);
    }


    @RequestMapping("/findAllUser")
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

}
