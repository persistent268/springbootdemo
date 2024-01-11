package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.AnnoyClass;
import cn.devcorp.demo.pojo.Person;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/11 11:08
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class AnnoMethodTest {
    @Test
    public void testAnnoy(){
        AnnoyClass annoyClass = new AnnoyClass(){
            @Override
            public void study() {
                Person person = new Person("tom", 23, "北京");
                System.out.println(JSON.toJSONString(person));
            }
        };
        annoyClass.study();
    }
}
