package com.zhuo.rabbitmq.producer;

import com.zhuo.rabbitmq.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.CorrelationDataPostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendOrder {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) throws Exception{
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange","order.abcd",order,correlationData);

    }
}
