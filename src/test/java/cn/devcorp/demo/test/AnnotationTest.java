package cn.devcorp.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/31 14:20
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class AnnotationTest {
    @Test
    public void test() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("cn.devcorp.demo.controller.UserController");
        if(clazz.isAnnotationPresent(RestController.class)){
            RestController restController = clazz.getAnnotation(RestController.class);
            String value = restController.value();
            System.out.println("hasAnnotation " + "value = " + value);

        }
    }
}
