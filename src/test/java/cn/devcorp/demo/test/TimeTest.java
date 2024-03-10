package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;

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
        LocalDateTime start = LocalDate.now()
                .with(ChronoField.DAY_OF_WEEK, 1)
                .minusWeeks(7)
                .atStartOfDay();
        System.out.println(start);
    }
    @Test
    public void testWeek(){
//        LocalDate now = LocalDate.of(2019,1,1);
//        LocalDate now = LocalDate.of(2020,1,1);
 //       LocalDate now = LocalDate.of(2021,1,1);
  //      LocalDate now = LocalDate.of(2022,1,1);
//        LocalDate now = LocalDate.of(2023,1,1);
        LocalDate now = LocalDate.of(2024,1,1);
        int weekOfYear = now.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        int weekOfYear2 = now.get(WeekFields.ISO.weekOfYear());
        int weekOfYear3 = now.get(WeekFields.of(Locale.CHINA).weekOfYear());
        System.out.println("weekOfYear = " + weekOfYear);
        System.out.println("weekOfYear2 = " + weekOfYear2);
        System.out.println("weekOfYear3 = " + weekOfYear3);
    }
}
