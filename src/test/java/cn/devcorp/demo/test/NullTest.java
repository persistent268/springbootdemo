package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/27 9:31
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class NullTest {
    @Test
    public void testNull(){
        int i = getInt();
        System.out.println(i);
    }
    @Test
    public void testEmptyList(){
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add(null);
        System.out.println(strings.isEmpty());
    }
    @Test
    public void testEmptyList2(){
        List<String> strings = new ArrayList<>();
        strings.add(null);
        System.out.println(strings.isEmpty());
    }

    public static int getInt(){
        Integer integerObject = null;
        return integerObject;
    }
}
