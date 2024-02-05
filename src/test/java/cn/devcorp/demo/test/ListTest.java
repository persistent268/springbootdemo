package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Book;
import cn.devcorp.demo.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
}
