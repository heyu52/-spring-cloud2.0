package com.cnblogs.demo.web;

import com.cnblogs.demo.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "消息", protocols = "http ")
public class WebController {

    // 演示：路径参数入参，以及注释换行（注释换行使用两个空格和一个\n）
    @ApiOperation(value = "获取用户信息,返回用户实体", notes = "此方法没有参数  \n创建时间:2019-06-26")
    @RequestMapping("/getUser")
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

    @ApiOperation(value = "获取用户名")
    @ApiImplicitParam(name = "name", value = "用户名参数", required = true, dataType = "String", paramType = "body")
    @RequestMapping("/getUserName")
    public String getUserName(String name) {
        return "这是我传入的参数:" + name;
    }

    @ApiOperation("获取用户列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "userId", dataType = "String", required = true, value = "user Id")})
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数不正确"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁⽌访问"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping("/GetUserlist")
    public List<User> GetUserlist(@RequestParam String userId) {
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


}