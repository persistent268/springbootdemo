package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/5 9:49
 *
 * <pre>

 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class TimeTest {
    @Test
    public void testChron(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusDays(5);
        System.out.println(ChronoUnit.DAYS.between(now,localDateTime));
        System.out.println("测试");
    }
    @Test
    public void testWorkDay(){
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(5);
    }
}
