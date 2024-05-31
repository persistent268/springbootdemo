package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.CarMapper;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
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
    @Test
    public void testMapBrand(){
        Map<String,Map<String,Object>> carMap = carMapper.selectMapBrand();
        System.out.println("carMap = " + carMap);
    }
    @Test
    public void testTranslate(){
        Translator.setUrlApi("http://192.168.0.150:5353/translate");
        System.out.println(Translator.translate(Language.CHINESE, Language.ENGLISH, "今天星期几"));
    }

}
