package com.cnblogs.demo.web;

import com.cnblogs.demo.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//注解相当于 @ResponseBody ＋ @Controller 合在一起的作用，如果 Web 层的类上使用了 @RestController 注解，
//就代表这个类中所有的方法都会以 JSON 的形式返回结果，也相当于 JSON 的一种快捷使用方式；
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


    //@Valid 参数前面添加 @Valid 注解，代表此对象使用了参数校验；
    //BindingResult 参数校验的结果会存储在此对象中，可以根据属性判断是否校验通过，
    //校验不通过可以将错误信息打印出来。
    @RequestMapping("/saveUser")
    public User saveUser(@Valid User user, BindingResult result) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);

        System.out.println(dateString + " user:" + user);
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + ":" + error.getDefaultMessage());
            }
        }

        return user;
    }
}