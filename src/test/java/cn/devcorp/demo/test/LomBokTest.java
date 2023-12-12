package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/26 21:11
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class LomBokTest {
    @Test
    public void testBuild(){
        Person person = Person.builder().name("张三").age(13).address("北京").build();
        System.out.println(person);
    }
}
