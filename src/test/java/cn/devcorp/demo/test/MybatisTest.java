package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.UserMapper;
import cn.devcorp.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/15 19:27
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class MybatisTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void testWhere(){
        User userVo = new User();
        userVo.setName("Jock");
        List<User> userList =  userMapper.queryUserByWhere(userVo);
        userList.forEach(user -> System.out.println(user));
    }
    @Test
    public void testWhere2(){
        User userVo = new User();
        userVo.setName("Jock");
        List<User> userList =  userMapper.queryUserByWhere2(userVo);
        userList.forEach(user -> System.out.println(user));
    }
}
