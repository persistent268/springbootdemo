package cn.devcorp.demo.test;

import cn.devcorp.demo.mapper.StudentsMapper;
import cn.devcorp.demo.pojo.Students;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 测试分页
 *
 * @author YK107
 * @date 2023/11/22 11:13
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class MpPageTest{
    @Resource
    private StudentsMapper studentsMapper;
    @Test
    public void testPage(){
        IPage<Students> page = new Page<>(1,5);
        page = studentsMapper.selectPage(page, null);
        List<Students> records = page.getRecords();
        long total = page.getTotal();
    }
    @Test
    public void testNull(){
        String studentName = "张三";
        LambdaQueryWrapper<Students> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(studentName),Students::getStudentName,studentName);
        List<Students> studentsList = studentsMapper.selectList(queryWrapper);
    }
}
