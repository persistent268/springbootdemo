package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Student;
import cn.devcorp.demo.utils.ValidatorUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/23 16:14
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class CompleTest {
    @Test
    public void testCom(){}
    @Test
    public void testCompare(){
        Student student1 = new Student("a","a",10.0);
        Student student2 = new Student("b","b",20.0);
        Student student3 = new Student("c","c",30.0);
        Student student4 = new Student(null,"d",30.0);
        Student student5 = new Student(null,"e",30.0);
        List<Student> studentList = Arrays.asList(student1,student2,student3,student4,student5,null);
        List<Student> collect = studentList.stream().filter(ValidatorUtils::isNotEmpty)
                .sorted(Comparator.comparing(Student::getName, Comparator.nullsLast(Comparator.reverseOrder()))).collect(Collectors.toList());
        collect.forEach(student -> System.out.println(student));
    }

}
