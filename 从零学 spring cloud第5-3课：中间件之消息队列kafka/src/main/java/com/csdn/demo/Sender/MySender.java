package com.csdn.demo.Sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MySender {

    @Resource
    KafkaTemplate kafkaTemplate;
    public void send() {
        //发送消息
        String msgKey="msgkey";
        String message="消息内容";
        kafkaTemplate.send("test", 0,msgKey,message);
        System.out.println( "这是发送的消息:"+message);
    }
}
