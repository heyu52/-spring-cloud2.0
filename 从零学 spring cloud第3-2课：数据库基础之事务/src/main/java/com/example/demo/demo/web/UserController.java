package com.example.demo.demo.web;

import com.example.demo.demo.Common.MyException;
import com.example.demo.demo.Repository.UserRepository;
import com.example.demo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping("/CreateUser")
    public int CreateUser() {
        int k = 0;
        User user = new User("csdn001", "男", 18);
        k = userRepository.save(user);

        if (true) {
            throw new RuntimeException("我报错了");
        }
        return k;
    }

    @RequestMapping("/saveThenRollback")
    public int saveThenRollback() {
        int k = 0;
        User user = new User("csdn002", "男", 18);

        try {
            userRepository.saveThenRollback(user);
        } catch (MyException e) {
           System.out.println("不好意思，我错了");
        }

        return k;
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
