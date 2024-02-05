package cn.devcorp.demo.utils;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Description: <EncodingUtil>
 *
 * @author duanss
 * @date 2022/1/7 15:37
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public class EncodingUtil {

    /**
     * Description:
     * <中文转码英文>
     * @author duanss
     * @date 15:40 2022/1/7
     * @param cn 1
     * @return java.lang.String
     **/
    public static String encodeB64(String cn) {
        return Base64Utils.encodeToString(cn.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Description:
     * <英文解码中文>
     * @author duanss
     * @date 15:40 2022/1/7
     * @param en 1
     * @return java.lang.String
     **/
    public static String decodeB64(String en) {
        return new String(Base64Utils.decodeFromString(en), StandardCharsets.UTF_8);
    }

    /**
     * Description:
     * <对传入的字符串进行编码>
     * @author duanss
     * @date 16:16 2021/12/13
     * @param key 1
     * @return java.lang.String
     **/
    public static String encodeURL(String key) {
        try {
            return URLEncoder.encode(key, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("数据编码异常");
        }
    }

}
