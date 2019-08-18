package com.csdn.demo.Sender;

import com.csdn.demo.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "这是我发送的消息";
        this.rabbitTemplate.convertAndSend("csdn", context);
        System.out.println("我是发送者 : " + context);
    }

    public void send(User user) {
        System.out.println("我是对象发送者: " + user.toString());
        this.rabbitTemplate.convertAndSend("csdn", user);
    }

}
