package com.itheima.publisher;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;


@SpringBootTest
@Slf4j
public class SpringAMQPTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    //测试直接向消息队列发消息
    public void testSendMsg2Queue() {
        String queName = "simple.queue";
        String msg = "hello mq!";
        rabbitTemplate.convertAndSend(queName, msg);
    }

    @Test
    //测试work模型，多消费者
    public void testWorkModel() throws InterruptedException {
        String queName = "work.queue";
        String msg;
        for (int i = 1; i <= 50; i++) {
            msg = "hello worker! message_" + i;
            rabbitTemplate.convertAndSend(queName, msg);
            Thread.sleep(20);
        }
    }

    @Test
    //测试fanout交换机:将消息广播到所有绑定的队列
    public void testSendFanout() {
        String exchageName = "hmall.fanout";
        String msg = "hello everyone";
        rabbitTemplate.convertAndSend(exchageName, "", msg);
    }

    @Test
    //测试direct交换机:将队列绑定到交换机时需要指定bindingKey，向交换机发送消息时指定routingKey，将消息发送到key一致的队列中
    public void testSendDirect() {
        String exchageName = "hmall.direct";
        String msg = "黄色警报";
        rabbitTemplate.convertAndSend(exchageName, "yellow", msg);
    }

    @Test
    //测试topic交换机:与direct交换机相比，key可以由多个单词组成，用“.”隔开，并支持通配符
    public void testSendTopic() {
        String exchageName = "hmall.topic";
        String msg = "今日天气晴";
        rabbitTemplate.convertAndSend(exchageName, "china.wether", msg);
    }

    /*@Test
    //测试发送object类型，使用默认序列化器（底层是序列化流）
    public void testSendObject() {
        String queName = "object.queue";
        HashMap<String, Object> msg = new HashMap<>();
        msg.put("name", "jack");
        msg.put("age", 21);
        rabbitTemplate.convertAndSend(queName, msg);
    }*/

    @Test
    //测试发送object类型，使用Json序列化器
    public void testSendObject2() {
        String queName = "object.queue";
        HashMap<String, Object> msg = new HashMap<>();
        msg.put("name", "jack");
        msg.put("age", 21);
        rabbitTemplate.convertAndSend(queName, msg);
    }

    @Test
    /**
     * 测试Publisher Confirm机制
     *  临时消息投递到了MQ，并且入队成功，返回ACK，告知投递成功
     *  持久消息投递到了MQ，并且入队完成持久化，返回ACK ，告知投递成功
     *  其它情况都会返回NACK，告知投递失败
     */
    public void testConfirmCallback() throws InterruptedException {
        CorrelationData cd = new CorrelationData();
        cd.getFuture().addCallback(new ListenableFutureCallback<CorrelationData.Confirm>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("消息回调失败", ex);
            }

            @Override
            public void onSuccess(CorrelationData.Confirm result) {
                if (result.isAck()) {
                    log.debug("消息发送成功，收到ack");
                } else {
                    log.debug("消息发送失败，收到nack，原因：{}", result.getReason());
                }
            }
        });
        rabbitTemplate.convertAndSend("hmall.direct", "red", "hello", cd);
        Thread.sleep(2000);
    }

    @Test
    public void testPageOut() {
        Message message = MessageBuilder.withBody("hello".getBytes(StandardCharsets.UTF_8))
                .setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT)
                .build();
        for (int i = 0; i < 1000000; i++) {
            rabbitTemplate.convertAndSend("simple.queue", message);
        }
    }

    @Test
    public void testLazyQueue() {
        Message message = MessageBuilder.withBody("hello".getBytes(StandardCharsets.UTF_8))
                .setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT)
                .build();
        for (int i = 0; i < 1000000; i++) {
            rabbitTemplate.convertAndSend("lazy.queue", message);
        }
    }

    @Test
    //测试利用死信交换机模拟延迟消息
    public void testSendDLX() {
        rabbitTemplate.convertAndSend("simple.direct", "123", "hello", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("10000");//设置消息的过期时间，到时未被消费，将进入死信交换机
                return message;
            }
        });
        log.info("消息发送成功！");
    }

    @Test
    //测试利用插件发送延迟消息
    public void testSendDelay() {
        rabbitTemplate.convertAndSend("delay.direct", "delay", "hello delay message", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay(10000);
                return message;
            }
        });
        log.info("消息发送成功！");
    }
}

