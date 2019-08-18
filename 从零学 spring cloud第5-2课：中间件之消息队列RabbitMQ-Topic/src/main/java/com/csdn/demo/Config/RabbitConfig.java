package com.csdn.demo.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    final static String TopicSendMessage = "Topic.SendMessage";
    final static String TopicSendMessageTest = "Topic.SendMessage.Test";

    @Bean
    public Queue TopicSendMessage() {
        return new Queue(RabbitConfig.TopicSendMessage);
    }

    @Bean
    public Queue TopicSendMessageTest() {
        return new Queue(RabbitConfig.TopicSendMessageTest);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("TopicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue TopicSendMessage, TopicExchange exchange) {
        return BindingBuilder.bind(TopicSendMessage).to(exchange).with("Topic.SendMessage");
    }

    @Bean
    Binding bindingExchangeMessages(Queue TopicSendMessageTest, TopicExchange exchange) {
        return BindingBuilder.bind(TopicSendMessageTest).to(exchange).with("Topic.#");
    }
}

