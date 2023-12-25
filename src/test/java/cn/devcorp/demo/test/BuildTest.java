package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/13 8:37
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class BuildTest {
    @Test
    public void testBuildPerson(){
        Person person = Person.builder().name(null).age(18).address("bj").build();
        System.out.println(person);
    }
}
