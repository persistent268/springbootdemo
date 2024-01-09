package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Author;
import cn.devcorp.demo.pojo.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/13 10:15
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class GenericTest {
    @Test
    public void testComparable(){
        List<Author> authorList = Arrays.asList(new Author("a",15),new Author("b",22),
                new Author("c",18));
//        authorList.stream().sorted(Comparator.reverseOrder());
    }
    @Test
    public void testGen(){
        Pair<String> stringPair = new Pair<>();
        stringPair.setName("zs");
    }
}
