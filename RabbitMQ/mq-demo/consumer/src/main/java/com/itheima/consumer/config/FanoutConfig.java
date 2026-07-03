package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FanoutConfig {

    //声明fanout路由
    @Bean
    public FanoutExchange fanoutExchange() {
        //return new FanoutExchange("hmall.fanout2");
        return ExchangeBuilder.fanoutExchange("hmall.fanout2").build();
    }

    //创建队列
    @Bean
    public Queue fanoutQueue3() {
        //return new Queue("fanout.queue3");
        return QueueBuilder.durable("fanout.queue3").build();
    }

    //将队列绑定到路由
    @Bean
    public Binding bindingQueue3(Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }
}
