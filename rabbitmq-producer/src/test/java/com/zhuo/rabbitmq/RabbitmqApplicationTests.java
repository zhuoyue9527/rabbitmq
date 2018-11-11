package com.zhuo.rabbitmq;

import com.zhuo.rabbitmq.entity.Order;
import com.zhuo.rabbitmq.producer.SendOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private SendOrder sendOrder;

    @Test
    public void testSend() throws Exception{
        Order order = new Order();
        order.setId("20180001");
        order.setName("测试1");
        order.setMessageId(System.currentTimeMillis()+"&"+ UUID.randomUUID().toString());
        sendOrder.send(order);
    }

}
