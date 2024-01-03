package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/30 20:10
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class BeanUtilsTest {
    @Test
    public void test(){
        Object a = null;
        User user = new User();
        BeanUtils.copyProperties(a, user);
        System.out.println(user);
    }
}
