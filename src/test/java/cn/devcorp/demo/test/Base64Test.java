package cn.devcorp.demo.test;

import cn.devcorp.demo.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Base64;
import java.util.UUID;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/14 9:48
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class Base64Test {
    @Test
    public void testBase64(){
        StringBuilder buffer = getMimeBuffer();
        byte[] encodedAsBytes = buffer.toString().getBytes();
        String encodedMime = Base64.getMimeEncoder().encodeToString(encodedAsBytes);
        System.out.println(encodedMime);
    }
    private static StringBuilder getMimeBuffer() {
        StringBuilder buffer = new StringBuilder();
        for (int count = 0; count < 10; ++count) {
            buffer.append(UUID.randomUUID().toString());
        }
        return buffer;
    }
    @Test
    public void testIO(){
        try {
            File file = new File("D:\\BaiduNetdiskDownload\\ON JAVA 中文版进阶卷 (Bruce Eckel) (z-lib.org).pdf");
            String base64File = FileUtils.encodeBase64File(file);
            System.out.println(base64File);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
