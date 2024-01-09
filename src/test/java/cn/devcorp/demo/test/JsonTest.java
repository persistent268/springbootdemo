package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Users;
import cn.devcorp.demo.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/28 20:34
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class JsonTest {
    @Test
    public void testJson(){
        CreateTenantRequestVo createTenantRequestVo = new CreateTenantRequestVo();
        CreateTenantDetailVo createTenantDetailVo = new CreateTenantDetailVo();
        TenantInfoVo tenantInfoVo = new TenantInfoVo();
        tenantInfoVo.setTenantName("系统名称");
        tenantInfoVo.setCreator("sfl");
        tenantInfoVo.setTenantKey("ten1");
        createTenantDetailVo.setTenantInfoVo(tenantInfoVo);
        TenantAdminsVo tenantAdminsVo = new TenantAdminsVo();
        tenantAdminsVo.setEmail("27@qq.com");
        tenantAdminsVo.setUsername("sfl");
        createTenantDetailVo.setTenantAdminsVo(tenantAdminsVo);
        WhiteListValueVo whiteListValueVo = new WhiteListValueVo();
        whiteListValueVo.setFileType(Arrays.asList("文件1","文件2"));
        whiteListValueVo.setSealType(Arrays.asList("签章1","签章2"));
        whiteListValueVo.setSignOrg(Arrays.asList("机构1,机构2"));
        createTenantDetailVo.setWhiteListValueVo(whiteListValueVo);
        createTenantRequestVo.setCreateTenantDetailVo(createTenantDetailVo);
        String jsonString = JSON.toJSONString(createTenantRequestVo);
        System.out.println(jsonString);
    }
    @Test
    public void testJsonGeneric(){
        // 构造数据
        Users user = new Users();
        user.setId(0);
        user.setName("tom");

        List<Users> users = new ArrayList<>();
        users.add(user);
        // 转为JSON字符串
        String jsonString = JSON.toJSONString(users);
//        List object = JSON.parseObject(jsonString, List.class);
        // 反序列化
        List<Users> usersGet = JSON.parseObject(jsonString, new TypeReference<List<Users>>(){});

        for (Users each : usersGet) {
            System.out.println(each);
        }
    }
}
