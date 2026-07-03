package com.itheima.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "spring.rabbitmq.listener.simple.retry", name = "enabled", havingValue = "true")
public class ErrorConfig {
    //指定在开启消费者处理消息失败重试机制的情况下，重试次数耗尽仍然失败的处理方式
    // RepublishMessageRecoverer将失败消息投递到指定交换机
    @Bean
    public MessageRecoverer errorMessageRecoverer(RabbitTemplate template) {
        return new RepublishMessageRecoverer(template, "error.direct", "error");
    }

    //声明处理失败消息的交换机
    @Bean
    public DirectExchange errorExchange() {
        return new DirectExchange("error.direct");
    }

    @Bean
    public Queue errorQueue() {
        return new Queue("error.queue");
    }

    @Bean
    public Binding errorBinding(@Qualifier("errorQueue") Queue errorQueue, @Qualifier("errorExchange") DirectExchange exchange) {
        return BindingBuilder.bind(errorQueue).to(exchange).with("error");
    }

    /*@Bean
    public Binding errorBinding(@Qualifier("errorQueue") Queue errorQueue, DirectExchange exchange) {
        return BindingBuilder.bind(errorQueue).to(exchange).with("error");
    }*/
}
