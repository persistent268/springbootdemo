package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/22 16:07
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class DateTest {
    @Test
    public void testDate(){
        Map<String, Long> timeMap = new HashMap<>();
        String startTimeStr = "2023-01-01 00:00:00";
        String endTimeStr = "2023-01-01 05:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);
        while (startTime.isBefore(endTime) || startTime.equals(endTime)) {
            String key = startTime.format(DateTimeFormatter.ofPattern("dd-HH"));
            timeMap.computeIfAbsent(key, k -> 0L);
            startTime = startTime.plusHours(1);
        }
        System.out.println(timeMap);
    }
    @Test
    public void testGDate(){
        Date date = new Date(0L);
        System.out.println(date);
        System.out.println(date);
    }
    @Test
    public void testInstant(){
//        Instant nowUtc = Instant.now();
//        System.out.println(nowUtc);
//        Instant instant = Instant.ofEpochMilli(0L);
//        System.out.println(instant);
//        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
////        System.out.println(time);
        //获取时间对象
//        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
//
//        // 解析/格式化器
//        DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss EE a");
//        // 格式化
//        System.out.println(dtf1.format(time));
        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();
        int nano = now.getNano();
        System.out.println(epochSecond);
        System.out.println(nano);
        //以中国标准时间解析Instant
        ZonedDateTime zonedDateTime = Instant.ofEpochSecond(epochSecond, nano).atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        //以UTC时间解析Instant
        ZonedDateTime zonedDateTimeUTC = Instant.ofEpochSecond(epochSecond, nano).atZone(ZoneId.of("UTC"));
        System.out.println(zonedDateTimeUTC);
    }
    @Test
    public void testChron(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime birthTime = LocalDateTime.of(2010, 5, 10, 0, 0, 0);
        long betweenDays = ChronoUnit.DAYS.between(birthTime, now);
        long betweenYears = ChronoUnit.YEARS.between(birthTime, now);
        System.out.println(betweenDays);
        System.out.println(betweenYears);
    }
    @Test
    public void testLocalDateTime(){
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss EE a");
//        //格式化-使用LocalDateTime也可以进行时间格式化
//        String nowFormat = now.format(dtf1);
//        System.out.println("格式化时间 " + nowFormat);
//        LocalDateTime parse = LocalDateTime.parse(nowFormat, dtf1);
//        System.out.println("解析时间 " + parse);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String s :
                availableZoneIds) {
            System.out.println(s);
        }
    }
}
