package com.csdn.demo.web;

import com.csdn.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("SaveUser")
    public String SaveUser() throws Exception {
        com.csdn.demo.model.User user=new com.csdn.demo.model.User();
        user.setId(3l);
        user.setUserName("csdn");
        userRepository.save(user);
        return  "创建用户成功";
    }

    @RequestMapping("deleteUserById")
    public String deleteUserById(){
        userRepository.deleteById(2L);
        return  "删除用户成功";
    }

    @RequestMapping("updateUser")
    public String updateUser(){
        com.csdn.demo.model.User user=new com.csdn.demo.model.User();
        user.setId(1l);
        user.setUserName("csdn99");
        userRepository.save(user);
        return  "更新用户成功";
    }

    @RequestMapping("findByUserName")
    public String findUserByUserName(){
        com.csdn.demo.model.User user= userRepository.findByUserName("csdn");
        return  user.toString();
    }

    @RequestMapping("findAllUser")
    public String findAllUser(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(2, 10, sort);
        Page page=userRepository.findAll(pageable);
       return page.getContent().toString() ;
    }
}
