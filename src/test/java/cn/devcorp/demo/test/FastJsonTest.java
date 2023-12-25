package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.User;
import cn.devcorp.demo.pojo.Users;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/25 16:36
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class FastJsonTest {
    @Test
    public void testGeneric(){
        String groupString = "{\"id\":0,\"name\":\"admin\",\"users\":[{\"id\":2,\"name\":\"guest\"},{\"id\":3,\"name\":\"root\"}]}";
        JSONObject jsonObject = JSON.parseObject(groupString);
        JSONArray users = jsonObject.getJSONArray("users");
        String jsonString = users.toJSONString();
        List<Users> usersList = JSON.parseArray(jsonString, Users.class);
        List<Users> usersList1 = JSON.parseObject(jsonString, new TypeReference<List<Users>>() {
        });
        usersList.forEach(System.out::println);
        usersList1.forEach(System.out::println);
    }
}
