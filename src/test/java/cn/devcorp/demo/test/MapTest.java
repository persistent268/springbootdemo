package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Car;
import cn.devcorp.demo.pojo.EsMappingModel;
import cn.devcorp.demo.pojo.User;
import cn.devcorp.demo.utils.ValidatorUtils;
import cn.devcorp.demo.vo.UsedEsealStatisticsResponseVo;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/26 11:24
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class MapTest {
    @Test
    public void testMap1(){
        String startTimeStr = "2023-01-01 00:00:00";
        String endTimeStr = "2023-01-01 05:00:00";
        List<EsMappingModel> value = null;
        Map<String,Long> map = new HashMap<>();
        for (Map.Entry<String, Long> map1 :
                map.entrySet()) {
            Map<String, Long> collect = value.stream().collect(Collectors.groupingBy(model -> model.getTimeYear() + "-" + model.getTimeMonth() + "-" + model.getTimeDay(), Collectors.counting()));
            Map<String, Long> dateRage1 = getDateRage1(startTimeStr, endTimeStr,
                    collect);
        }
    }
    public static Map<String, Long> getDateRage1(String startTimeStr, String endTimeStr, Map<String, Long> timeMap) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);
        while (startTime.isBefore(endTime) || startTime.equals(endTime)) {
            String key = startTime.format(DateTimeFormatter.ofPattern("dd-HH"));
            timeMap.computeIfAbsent(key, k -> 0L);
            startTime = startTime.plusHours(1);
        }
        return new TreeMap<>(timeMap);
    }
    @Test
    public void testPutIfAbsent(){
        UsedEsealStatisticsResponseVo usedEsealStatisticsResponseVo = new UsedEsealStatisticsResponseVo();
        Map<String,Long> statisticalChartMap = new HashMap<>();
        usedEsealStatisticsResponseVo.setStatisticalChartMap(statisticalChartMap);
        if(true){
            Map<String,Long> newMap = new HashMap<>();
            newMap.put("key1",1L);
            newMap.put("key2",2L);
            statisticalChartMap = newMap;
        }
        System.out.println(usedEsealStatisticsResponseVo);
    }

    @Test
    public void testGet(){
        Car car = new Car();

    }
    @Test
    public void testDebugMap(){
        Map<String,String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        System.out.println(map);
    }
    @Test
    public void testDebugList(){
      List<String> list = new ArrayList<>();
      list.add("zhang");
      list.add("san");
    }
}
