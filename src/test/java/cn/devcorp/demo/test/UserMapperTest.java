package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.UserMapper;
import cn.devcorp.demo.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/25 11:48
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void testMap(){
        QueryWrapper<User> qm = new QueryWrapper<User>();
        qm.select("count(*) as nums ,gender" );
        qm.groupBy( "gender");
        List<Map<String,Object>> maps = userMapper.selectMaps(qm);
        System.out.println(maps);
    }
    @Test
    public void testOneMany(){
        Long id = 1L;
        User user = userMapper.queryUserOrders(id);
        System.out.println(user);
    }
    @Test
    public void testUserMp(){
        Long id = 1L;
        User user = userMapper.selectById(id);
        System.out.println(user);
    }
    @Test
    public void testM(){
        Long id = 1L;
        User user = userMapper.selectByIdDefine(id);
        System.out.println(user);
    }
}
