package com.csdn.demo.web;

import com.csdn.demo.MQProducer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myControl {
    @Autowired
    private Producer producer;


    @RequestMapping("/MySendMethod")
    public void MySendMethod() {
        this.producer.sendQueue("MySendMethod queue message");
    }

    @RequestMapping("/MySendTopicMethod")
    public void MySendTopicMethod() {
        this.producer.sendTopic("MySendTopicMethod queue message");
    }
}
