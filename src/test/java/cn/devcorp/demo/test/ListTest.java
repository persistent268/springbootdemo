package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Book;
import cn.devcorp.demo.pojo.Category;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.*;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/3 9:17
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class ListTest {
    @Test
    public void testToArray(){
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();
        List<Category> categoryList1 = Arrays.asList(new Category(1, "品类1"), new Category(2, "品类2"));
        map.put("category",categoryList1);
        System.out.println(map);
        List<Category> categoryList = (List<Category>) map.get("category");
        categoryList.forEach(category -> System.out.println(category));
    }
    @Test
    public void testLocalDate(){
        String date = "2023-09-01";
        LocalDate parse = LocalDate.parse(date);
        System.out.println(parse);
    }
    @Test
    public void testPartion(){
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);
        for (List<Integer> subSet :
                subSets) {
            subSet.forEach(System.out::print);
            System.out.println();
        }
    }
    @Test
    public void testTime(){
        LocalDate localDate = LocalDate.of(2024, 3, 10);
        LocalDateTime start =localDate
                .with(ChronoField.DAY_OF_WEEK, 1)
                .minusWeeks(1)
                .atStartOfDay();
        System.out.println(start);
    }
    @Test
    public void testLocalDate1(){
//        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
//        System.out.println(previousMonthSameDay);
//        DayOfWeek dayOfWeek = LocalDate.parse("2024-03-08").getDayOfWeek();
//        int dayOfMonth = LocalDate.parse("2024-03-08").getDayOfMonth();
//        System.out.println("dayOfMonth = " + dayOfMonth);
//        System.out.println("dayOfWeek = " + dayOfWeek);
//        LocalDateTime beginningOfDay = LocalDate.parse("2024-03-08").atStartOfDay();
//        LocalDate firstDayOfMonth = LocalDate.parse("2024-03-08")
//                .with(TemporalAdjusters.firstDayOfMonth());
//        System.out.println("firstDayOfMonth = " + firstDayOfMonth);
//        System.out.println("beginningOfDay = " + beginningOfDay);
        LocalDate now = LocalDate.now();
        LocalDate alignedToMonday = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
//        now.with(ChronoUnit.)
    }
    @Test
    public void testChangeTime(){
        LocalDateTime dateTime1 = LocalDateTime.now().plusHours(1).with(TemporalAdjusters.previous(DayOfWeek.SATURDAY));
        LocalDateTime dateTime2 = LocalDateTime.now().plusHours(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));
        System.out.println("dateTime1 = " + dateTime1);
        System.out.println("dateTime2 = " + dateTime2);
    }
    @Test
    public void testChronField(){
//        LocalDateTime mondayStart = LocalDate.now().with(ChronoField.DAY_OF_WEEK, 1)
//                .atStartOfDay();
//        System.out.println("mondayStart = " + mondayStart);
//        // 获取当前日期时间
//        LocalDateTime currentDateTime = LocalDateTime.now();
//
//        // 获取当前日期时间所在周的周一
//        LocalDateTime monday = currentDateTime.with(DayOfWeek.MONDAY).with(LocalTime.MIN);
//
//        System.out.println("本周的周一开始时间点：" + monday);
        // 使用 LocalDate 获取当前日期
        LocalDate date = LocalDate.now();
        // 获取当前日期是一年中的第几个“对齐周”
        int alignedWeekOfYear = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        // 打印结果
        System.out.println("Aligned week of year: " + alignedWeekOfYear);
    }
}
