package com.csdn.demo.Config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class MqConfig {

    @Bean
    ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://192.168.0.123:61616");
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("admin");
        return connectionFactory;
    }

    @Bean
    public Queue queue()
    {
        return  new ActiveMQQueue("csdn.queue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("csdn.topic");
    }
}


