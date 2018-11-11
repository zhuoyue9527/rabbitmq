package com.zhuo.rabbitmq.producer;


import com.rabbitmq.client.Channel;
import com.zhuo.rabbitmq.entity.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class OrderReceive {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value="order-queue" ,durable = "true"),
            exchange = @Exchange(value = "order-exchange",durable = "true",type = "topic"),
            key = "order.#"
    ))
    @RabbitHandler
    public void receive(@Payload Order order,
                        @Headers Map<String,Object> headers ,
                        Channel channel) throws  Exception{
        System.out.println("--------------接受消息-------------------------");
        System.out.println("订单ID是："+order.getId());
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);

    }
}
