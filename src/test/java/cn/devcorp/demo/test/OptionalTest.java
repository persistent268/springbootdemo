package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Phone;
import cn.devcorp.demo.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/25 18:34
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class OptionalTest {
    @Test
    public void testOptional(){
//        Phone phone = new Phone();
//        phone.setPhoneName("xm");
//        phone.setNo(1001);
        Phone phone = null;
        Optional<Phone> optional = Optional.ofNullable(phone);
        //存在即返回,为空则提供默认值
        Phone phoneOrElse = optional.orElse(new Phone());
        System.out.println(phoneOrElse);
        //存在即返回,空则由函数生成
        Phone phoneOrElseGet = optional.orElseGet(() -> new Phone());
        System.out.println(phoneOrElseGet);
        //存在即返回,否则抛出异常
        Phone phoneThrow = optional.orElseThrow(() -> new RuntimeException());
        System.out.println(phoneThrow);
        //存在才去做相应的处理
        optional.ifPresent(phone1-> System.out.println(phone1.getPhoneName()));
        //map可以对Optional中的对象执行某种操作,且会返回一个Optional对象
        String phoneMap = optional.map(u -> u.getPhoneName()).orElse("iPhone");
        System.out.println(phoneMap);
    }
}
