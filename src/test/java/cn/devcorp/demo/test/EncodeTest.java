package cn.devcorp.demo.test;

import cn.devcorp.demo.utils.EncodingUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/12 17:29
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class EncodeTest {
    @Test
    public void testResponse(){
        System.out.println(EncodingUtil.encodeURL("PDF-竖版"));
    }
}
