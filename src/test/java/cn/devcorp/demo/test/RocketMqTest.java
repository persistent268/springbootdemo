package cn.devcorp.demo.test;

import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.websocket.SendResult;
import java.util.HashMap;
import java.util.Map;


/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/28 9:15
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class RocketMqTest {
    @Test
    public void testSend(){
//        ClientServiceProvider clientServiceProvider = ClientServiceProvider.loadService();
//        Producer producer = clientServiceProvider.newProducerBuilder().
//                setMaxAttempts()
//        .build();
//        Message message = clientServiceProvider.newMessageBuilder().build();
//        SendReceipt sendReceipt = producer.send(message);
//        sendReceipt.
        Map<String,Object> map = new HashMap<>();
        String s = (String)map.get("a");
        System.out.println(s);
    }
}
