package com.itheima.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MqListener {
    //@RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg) {
        System.out.println("收到来自simple.queue队列的消息：" + msg);
        throw new RuntimeException("bug");
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1收到来自work.queue队列的消息:" + msg);
        Thread.sleep(20);
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2收到来自work.queue队列的消息:" + msg);
        Thread.sleep(200);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) {
        System.out.println("消费者1收到来自fanout.queue1队列的消息:" + msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) {
        System.out.println("消费者2收到来自fanout.queue2队列的消息:" + msg);
    }

    //基于注解创建队列，交换机并进行绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1", durable = "true"),
            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue1(String msg) {
        System.out.println("消费者1收到来自direct.queue1队列的消息:" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2", durable = "true"),
            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueue2(String msg) {
        System.out.println("消费者2收到来自direct.queue2队列的消息:" + msg);
    }

    @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(String msg) {
        System.out.println("消费者1收到来自topic.queue1队列的消息:" + msg);
    }

    @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(String msg) {
        System.out.println("消费者2收到来自topic.queue2队列的消息:" + msg);
    }

    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String, Object> msg) {
        System.out.println("消费者收到来自object.queue队列的消息:" + msg);
    }

    @RabbitListener(queues = "dlx.queue")
    public void listenDLXQueue(String msg) {
        log.info("收到来自dlx.queue队列的死信:" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "delay.queue", durable = "true"),
            exchange = @Exchange(name = "delay.direct", delayed = "true"),
            key = "delay"
    ))
    public void listenDelayQueue(String msg) {
        log.info("收到来自delay.queue队列的延迟消息:" + msg);
    }
}
