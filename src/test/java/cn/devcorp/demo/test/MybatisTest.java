package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.UserMapper;
import cn.devcorp.demo.pojo.SignTaskDocument;
import cn.devcorp.demo.pojo.SignTaskDto;
import cn.devcorp.demo.pojo.User;
import cn.devcorp.demo.utils.BeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        userVo.setName("sfl");
        List<User> userList =  userMapper.queryUserByWhere(userVo);
        userList.forEach(user -> System.out.println(user));
    }
    @Test
    public void testOne(){
        User userVo = new User();
        userVo.setName("sfl");
        User user =  userMapper.queryUserOneByWhere(userVo);
        System.out.println(user);
    }
    @Test
    public void testWhere2(){
        User userVo = new User();
        userVo.setName("Jock");
        List<User> userList =  userMapper.queryUserByWhere2(userVo);
        userList.forEach(user -> System.out.println(user));
    }
    @Test
    public void testNullArray(){
        List<String> list = new ArrayList();
        List<String> stringList = BeanUtils.copyList(list, String.class);
        System.out.println(stringList);
    }
    @Test
    public void testArray(){
        List<SignTaskDto> querySignTaskDtoList = Collections.emptyList();
        List<SignTaskDocument> collect = querySignTaskDtoList.stream().flatMap(q -> q.getFileList().stream()).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void testLongString(){
        String s = userMapper.selectByDe("Tom");
        System.out.println(s);
    }
    @Test
    public void testEqual(){
        boolean equals = Objects.equals(null, null);
        System.out.println(equals);
    }
}
