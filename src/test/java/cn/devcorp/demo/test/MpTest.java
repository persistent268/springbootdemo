package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.OrderMapper;
import cn.devcorp.demo.mapper.StudentsMapper;
import cn.devcorp.demo.pojo.Order;
import cn.devcorp.demo.pojo.Student;
import cn.devcorp.demo.pojo.Students;
import cn.devcorp.demo.utils.SnowFlakeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
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
    @Resource
    private OrderMapper orderMapper;
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
    @Test
    public void testMpUpdate(){
        //UPDATE students SET score=? WHERE (student_id = ?)
        Students students = new Students();
        students.setScore(100);
        LambdaUpdateWrapper<Students> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Students::getId,3);
        studentsMapper.update(students,updateWrapper);
    }
    @Test
    public void testIn(){
        List<Integer> idList = new ArrayList<>();
        LambdaQueryWrapper<Students> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Students::getId,idList);
        List<Students> students = studentsMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        Students students = new Students();
        students.setStudentName("lisi");
        students.setSubject("program");
        students.setScore(90);
        studentsMapper.insert(students);
    }
    @Test
    public void testSnowFlake(){
//        System.out.println(SnowFlakeUtil.getID());
//
//        System.out.println("1761326571800956929".length());
//        System.out.println("9223372036854775807".length());

    }
    @Test
    public void testLongMax(){
//        double pow = Math.pow(2, 63) - 1;
//        System.out.println(pow);
//        System.out.println(String.valueOf(pow).length());
        long a = 922337203685477580L;
    }
    @Test
    public void testApply(){
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.apply("date_format(order_time,'%Y-%m-%d') = '2023-12-10'");
        List<Order> orderList = orderMapper.selectList(queryWrapper);
       orderList.forEach(System.out::println);
    }
}
