package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Person;
import cn.devcorp.demo.pojo.User;
import cn.devcorp.demo.pojo.Users;
import cn.devcorp.demo.result.ResultVo;
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
    @Test
    public void testJsonDeSerialize(){
        String jsonStr = "{\"address\":\"北京\",\"age\":23,\"name\":\"tom\"}";
        //反序列化为Person对象
        Person person = JSON.parseObject(jsonStr, Person.class);
        //返回给调用端ResultVo
        ResultVo<Person> personResultVo = ResultVo.buildSuccess(person);
        //序列化返回给调用端
        String voJsonStr = JSON.toJSONString(personResultVo);
        //调用端把voJsonStr反序列化为对象
        //反序列化不能获取泛型类型,所以getData返回的就是Object
//        ResultVo resultVo = JSON.parseObject(voJsonStr, ResultVo.class);
//        System.out.println("resultVo = " + resultVo);
//        Object data = resultVo.getData();
//        System.out.println(data.getClass());
        ResultVo<Person> resultVo = JSON.parseObject(voJsonStr, new TypeReference<ResultVo<Person>>() {
        });
        Person data = resultVo.getData();
    }
    @Test
    public void testJson(){
        Person person = new Person();
        person.setName("张三");
        System.out.println(JSON.toJSONString(person));
    }
}
