package com.csdn.demo.web;

import com.csdn.demo.Sender.MySender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MySender sender;

    @RequestMapping("mySend")
    public void mySend() throws Exception {
        sender.send();
    }


    @RequestMapping("TopicSendMessage")
    public void TopicSendMessage() throws Exception {
        sender.TopicSendMessage();
    }


    @RequestMapping("TopicSendMessageTest")
    public void TopicSendMessageTest() throws Exception {
        sender.TopicSendMessageTest();
    }
}
