package com.csdn.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.csdn.demo.model.User;

@RestController
public class UserController {
    @Autowired
    private com.csdn.demo.dao.UserMapper userMapper;

    @RequestMapping("/getUserById")
    public User getUserById(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
