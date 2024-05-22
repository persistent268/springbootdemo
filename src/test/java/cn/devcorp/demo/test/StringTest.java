package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/3/10 14:01
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class StringTest {
    @Test
    public void testFormat(){
        String format = "%s%d";
        String result = String.format(format, "a", 2);
        System.out.println("result = " + result);//result = a2
    }
}
