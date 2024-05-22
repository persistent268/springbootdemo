package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/5/20 17:45
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class ContainsTest {
    @Test
    public void testContains(){
        List<String> list = Arrays.asList("009-02","009-03");
        boolean contains = list.contains("009-02");
        System.out.println("contains = " + contains);
    }
    @Test
    public void testDay(){
        LocalDateTime now = LocalDateTime.now();
        //获取当前周几
        int weekNo = now.getDayOfWeek().getValue();
        System.out.println("weekNo = " + weekNo);
        //获取今天是本月的第几日
        int day = now.getDayOfMonth();
        System.out.println(day);
        int monthValue = now.getMonthValue();
        System.out.println("monthValue = " + monthValue);
        int year = now.getYear();
        int lengthOfMonth = YearMonth.of(year, monthValue).lengthOfMonth();
        System.out.println("lengthOfMonth = " + lengthOfMonth);
    }
}
