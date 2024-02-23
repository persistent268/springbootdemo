package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

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
    public void testGroupBy(){

    }
}
