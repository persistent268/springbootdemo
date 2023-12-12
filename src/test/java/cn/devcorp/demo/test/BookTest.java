package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.BookMapper;
import cn.devcorp.demo.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/10 15:32
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class BookTest {
    @Resource
    private BookMapper bookMapper;
    @Test
    public void testManyToMany(){
        //查询book以及所属的分类信息
        List<Book> bookList = bookMapper.queryBookAndCategory();
        bookList.forEach(book -> System.out.println(book));
    }
}
