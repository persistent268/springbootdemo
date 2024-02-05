package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/1 18:15
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class LocalDateTimeTest {
    @Test
    public void testLocalDate(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusMinutes(30);
        System.out.println("当前时间减去30分钟 " + localDateTime);
        LocalDateTime dateTime = LocalDateTime.of(2024, 2, 1, 18, 23, 0);
        System.out.println("指定时间toString " + dateTime.toString());
    }
}
