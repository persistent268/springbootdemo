package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.StudentsMapper;
import cn.devcorp.demo.pojo.Student;
import cn.devcorp.demo.pojo.Students;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/19 15:02
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class MpTest {
    @Resource
    private StudentsMapper studentsMapper;
    @Test
    public void testSelectMaps(){
        QueryWrapper<Students> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("student_name","score");
        List<Map<String, Object>> maps = studentsMapper.selectMaps(queryWrapper);
        maps.forEach(map -> {
            System.out.println(map);
        });
    }
    @Test
    public void testSelectList(){
        QueryWrapper<Students> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("student_name","score");
        List<Students> studentsList = studentsMapper.selectList(queryWrapper);
        studentsList.forEach(student -> System.out.println(student));
    }
    @Test
    public void testStream(){
        List<Student> students = Arrays.asList(new Student[] {
                new Student("zhangsan", "1", 91d), new Student("lisi", "2", 89d),
                new Student("wangwu", "1", 50d), new Student("zhaoliu", "2", 78d),
                new Student("sunqi", "1", 59d)});
        Map<String, Long> collect = students.stream().collect(Collectors.groupingBy(student -> student.getGrade(), Collectors.counting()));
        for (Map.Entry<String, Long> entry :
                collect.entrySet()) {
            System.out.println(entry);
        }
    }
    @Test
    public void testStreamSortReverse1(){
        List<Student> students = Arrays.asList(new Student[] {
                new Student("zhangsan", "1", 91d), new Student("lisi", "2", 89d),
                new Student("wangwu", "1", 50d), new Student("zhaoliu", "2", 78d),
                new Student("sunqi", "1", 59d)});
        List<Student> studentList = students.stream().sorted(Comparator.comparing(Student::getName).reversed()).collect(Collectors.toList());
        studentList.forEach(student -> System.out.println(student));
    }
    @Test
    public void testStreamSortReverse2(){
        List<Student> students = Arrays.asList(new Student[] {
                new Student("zhangsan", "1", 91d), new Student("lisi", "2", 89d),
                new Student("wangwu", "1", 50d), new Student("zhaoliu", "2", 78d),
                new Student("sunqi", "1", 59d)});
        List<Student> studentList = students.stream().sorted(Comparator.comparing(Student::getName,Comparator.reverseOrder())).collect(Collectors.toList());
        studentList.forEach(student -> System.out.println(student));
    }
    @Test
    public void testSelectOne(){
        Students students = studentsMapper.selectById(10);
        System.out.println(students);
    }
    @Test
    public void testUpdateConditional(){
        String studentName = null;
        String subject = null;
        studentsMapper.update(null,new LambdaUpdateWrapper<Students>()
                .eq(Students::getSubject,subject)
                .set(Students::getStudentName,studentName));
    }
}
