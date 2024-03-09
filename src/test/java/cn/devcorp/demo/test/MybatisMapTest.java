package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.CarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/3/9 15:40
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class MybatisMapTest {
    @Resource
    private CarMapper carMapper;
    @Test
    public void testMap(){
        String brand = "奥迪A6";
        Map<String,Object> carMap = carMapper.selectOneMap(brand);
        System.out.println("carMap = " + carMap);
    }
    @Test
    public void moreMap(){
        List<Map<String,Object>> carMap = carMapper.selectMoreMap();
        System.out.println("carMap = " + carMap);
    }
    @Test
    public void testMapMap(){
        Map<Long,Map<String,Object>> carMap = carMapper.selectMapMap();
        System.out.println("carMap = " + carMap);
    }
}
