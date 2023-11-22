package cn.devcorp.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/17 9:50
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootApplication
@MapperScan("cn.devcorp.demo.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
