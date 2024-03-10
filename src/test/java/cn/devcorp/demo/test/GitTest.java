package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.QuerySignTaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/29 17:06
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class GitTest {
    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();
        QuerySignTaskDto build = QuerySignTaskDto.builder().
                taskId(map.get("taskId") != null ? Long.parseLong((String) map.get("taskId")) : null)
                .build();
        System.out.println(build);//QuerySignTaskDto(taskId=null)

    }
    @Test
    public void test2(){
        Map<String,Object> map = new HashMap<>();
        QuerySignTaskDto.QuerySignTaskDtoBuilder builder = QuerySignTaskDto.builder();
        if(map.get("taskId") != null){
            builder .
                    taskId(map.get("taskId") != null ? Long.parseLong((String) map.get("taskId")) : null);
        }
        System.out.println(builder.build());

    }
    @Test
    public void updateGit(){
        System.out.println("更新配置文件,active changeList");
    }
    @Test
    public void testPush(){
        System.out.println("提交文件");
    }
}
