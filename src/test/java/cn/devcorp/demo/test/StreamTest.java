package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Author;
import cn.devcorp.demo.utils.ValidatorUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    @Test
    public void testFindAny(){
        List<Author> authorList = Arrays.asList(new Author("a",15),new Author("b",22),
                new Author("c",18));
        boolean anyMatch = authorList.stream().filter(author -> author.getAge() > 13).anyMatch(author -> author.getName().equals("c"));
        System.out.println(anyMatch);
    }
    @Test
    public void testReduce(){
        List<Integer> integerList = Arrays.asList(1, 3, 5, 7, 9);
        Integer sum = integerList.stream().reduce(0, Integer::sum);
    }
    @Test
    public void testToMapNull(){
        List<Author> authorList = Arrays.asList(new Author("a",15),new Author("b",22),
                new Author("c",18),null);
        //演示为null的情况
        authorList.forEach(System.out::println);
        List<Author> authors = authorList.stream().collect(Collectors.toList());
        System.out.println(authors);
    }
}
