package com.csdn.demo.web;

import com.csdn.demo.Sender.MySender;
import com.csdn.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MySender mySender;

    @RequestMapping("/MySendMethod")
    public void MySendMethod() throws Exception {
        mySender.send();
    }

    @RequestMapping("/MySend5")
    public void MySend5 () throws Exception {
        for (int i=0;i<5;i++) {
            mySender.send();
        };
    }

    @RequestMapping("/SendUser")
    public void SendUser() throws Exception {
        User user=new User();
        user.setName("csdn");
        user.setSex("男");
        mySender.send(user);
        Thread.sleep(1000l);
    }
}
