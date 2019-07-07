package com.csdn.demo;

import com.csdn.demo.enums.UserSexEnum;
import com.csdn.demo.mapper.UserMapper;
import com.csdn.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetUserById()   {
        User user = userMapper.getUserById(62L);
        System.out.println("user :"+user.toString());
        System.out.println( user.getSex());
        Assert.assertTrue((UserSexEnum.男 ==(user.getSex())));

    }

}
