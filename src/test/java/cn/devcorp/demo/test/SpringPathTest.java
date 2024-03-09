package cn.devcorp.demo.test;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/28 15:52
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class SpringPathTest {
    @Autowired
    private ResourceLoader resourceLoader;
    @Test
    public void testClassPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/cat.jpg");
        FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\spark\\Desktop\\tmp\\cat.jpg"));
        IOUtils.copy(resource.getInputStream(),outputStream);
    }
    @Test
    public void testClassPath2() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:simple.xlsx");
        FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\spark\\Desktop\\tmp\\simple.xlsx"));
        IOUtils.copy(resource.getInputStream(),outputStream);
    }
    @Test
    public void testClassPath3() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:simple.xlsx");
    }
    @Test
    public void testString(){
        String name = "john";
        int age = 10;
        double score = 56.857;
        char gender = '男';
//将所有的信息都拼接在一个字符串.
        String info =
                "我的姓名是" + name + "年龄是" + age + ",成绩是" + score + "性别是" + gender + "。希望大家喜欢我！";

        System.out.println(info);

        String formatStr = "我的姓名是%s 年龄是%d，成绩是%.2f 性别是%c.希望大家喜欢我！";

        String info2 = String.format(formatStr, name, age, score, gender);

        System.out.println("info2=" + info2);
    }
}
