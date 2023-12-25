package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/25 17:19
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class InstanceOfTest {
    @Test
    public void testIn(){
        User user = new User();
        System.out.println(user instanceof Object );
        System.out.println(null instanceof Object);
    }
}
