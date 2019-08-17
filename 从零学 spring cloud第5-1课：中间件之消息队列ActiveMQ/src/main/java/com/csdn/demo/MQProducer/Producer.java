package com.csdn.demo.MQProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
//消息的生产者
public class Producer {
    //Spring 提供发送消息的工具类
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue query;

    public void sendQueue(String msg){
        System.out.println("send queue msg:"+msg);
        this.jmsMessagingTemplate.convertAndSend(this.query,msg);
    }

    @Autowired
    private Topic topic;

    public void sendTopic(String msg) {
        System.out.println("发送广播消息 :"+msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }

}
