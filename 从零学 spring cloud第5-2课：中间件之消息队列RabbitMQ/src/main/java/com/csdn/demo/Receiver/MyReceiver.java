package com.csdn.demo.Receiver;

import com.csdn.demo.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "csdn")
public class MyReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("我是接收者  : " + hello);
    }

    @RabbitHandler
    public void process(User user) {
        System.out.println("我是对象接收者 : " + user);
    }

}
