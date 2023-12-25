package cn.devcorp.demo.utils;

import org.apache.commons.net.util.Base64;

import java.io.*;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/22 9:28
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public class FileUtils {
    public static String encodeBase64File(File file) throws IOException {
        try (FileInputStream inputFile = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputFile);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            // 使用较小的buffer进行读取，而不是一次性读取整个文件
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            // 使用Apache commons codec库进行Base64编码
            byte[] bytesToEncode = byteArrayOutputStream.toByteArray();
            return Base64.encodeBase64String(bytesToEncode);
        }
    }
}
