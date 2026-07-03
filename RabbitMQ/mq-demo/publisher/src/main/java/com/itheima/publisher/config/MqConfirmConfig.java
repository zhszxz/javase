package com.itheima.publisher.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MqConfirmConfig implements ApplicationContextAware {
    //处理Publisher Return返回异常信息：当消息投递到MQ，但是路由失败时，返回异常信息，同时返回ack的确认信息，代表投递成功
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                log.debug("收到消息的return callback，exchange：{}，key：{}，msg：{}，code：{}，text：{}",
                        returnedMessage.getExchange(), returnedMessage.getRoutingKey(), returnedMessage.getMessage(),
                        returnedMessage.getReplyCode(), returnedMessage.getReplyText());
            }
        });
    }
}
