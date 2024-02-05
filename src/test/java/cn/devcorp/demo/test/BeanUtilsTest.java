package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.*;
import cn.devcorp.demo.utils.BeanUtilsMy;
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
    @Test
    public void testBeanUtilsGet(){
        Phone phone = new Phone("小米", 133);
        Mobile mobile = new Mobile();
        BeanUtils.copyProperties(phone,mobile);
        System.out.println(mobile);
    }
    @Test
    public void testBeanUtils(){
        SignTask signTask = new SignTask();
        signTask.setSignType(1);
        signTask.setTaskName("signTask");
        SignTaskDto signTaskDto = new SignTaskDto();
        BeanUtils.copyProperties(signTask,signTaskDto);
        System.out.println(signTaskDto);
    }
    @Test
    public void testBeanUtil(){
        SignTask signTask = new SignTask();
        signTask.setSignType(1);
        signTask.setTaskName("signTask");
        SignTaskDto signTaskDto = new SignTaskDto();
        BeanUtilsMy.copyProperties(signTask,signTaskDto);
        System.out.println(signTaskDto);
    }
}
