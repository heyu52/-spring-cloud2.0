package com.csdn.demo.web;

import com.csdn.demo.Repository.UserRepository;
import com.csdn.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @RequestMapping("/findAllUser")
    public Page<User> findAllUser()
    {
        int page=0,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findAllUser(pageable);
    }

    @RequestMapping("/findByUserName")
    public Page<User> findByUserName(String name)
    {
        int page=0,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findByUserName(name,pageable);
    }

    @RequestMapping("/findByUserName2")
    public Page<User> findByUserName2(String name)
    {
        int page=0,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findByUserName2(name,pageable);
    }

    @RequestMapping("/updateUserNameById")
    public int updateUserNameById(String name,Long id)
    {
        return userRepository.updateUserNameById(name,id);
    }

    @RequestMapping("/findBySex3")
    public  List<User> findBySex3(String sex)
    {
        return userRepository.findBySex3(sex);
    }

    @RequestMapping("/findByName3")
    public  List<User> findByName3(String name)
    {
        return userRepository.findByName3(name);
    }


}
