package cn.devcorp.demo.test;

import cn.devcorp.demo.enums.SignTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/22 14:17
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class EnumTest {
    @Test
    public void testEnum(){
        List<Map<String, Object>> codeMessageList = new ArrayList<>();
        for (SignTypeEnum value : SignTypeEnum.values()) {
            Map<String, Object> codeMessageMap = new HashMap<>();
            codeMessageMap.put("id", value.getCode());
            codeMessageMap.put("value", value.getMessage());
            codeMessageList.add(codeMessageMap);
        }
        // 输出结果
        for (Map<String, Object> map : codeMessageList) {
            System.out.println(map);
        }
    }
}
