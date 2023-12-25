package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Author;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/12 14:48
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class StreamTest {
    @Test
    public void testFindFirst(){
        List<Author> authorList = Arrays.asList(new Author("a",15),new Author("b",22),
                new Author("c",18));
        Optional<Author> author = authorList.stream().sorted(Comparator.comparing(Author::getAge)).findFirst();
        author.ifPresent(System.out::println);
    }
    @Test
    public void testCompaNull(){
        List<String> fruits =  Arrays.asList("pear", "apple", "grapes", null, "orange");
        fruits.sort(Comparator.naturalOrder());
        System.out.println(fruits);
    }
}
