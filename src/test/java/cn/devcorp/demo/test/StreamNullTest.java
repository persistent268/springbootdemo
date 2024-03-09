package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Author;
import cn.devcorp.demo.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/14 19:32
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class StreamNullTest {
    @Test
    public void testNull(){
        List<Author> authorList = Arrays.asList(new Author("张三", 18), new Author("李四", 20));
        authorList = Collections.emptyList();
        System.out.println(authorList);
        List<Integer> collect = authorList.stream().map(Author::getAge).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void testGroup(){
        List<Person> peopleList = Arrays.asList(
                new Person("张三", 25, "上海"),
                new Person("李四", 30, "北京"),
                new Person("张三", 25, "上海"),
                new Person("赵六", 30, "深圳"),
                new Person("李四", 40, "北京")
        );
        Map<String, Person> collect = peopleList.stream()
                .collect(Collectors.toMap(Person::getName, Function.identity(),(oldValue,newValue) -> newValue ));
        System.out.println(collect);
    }
}
