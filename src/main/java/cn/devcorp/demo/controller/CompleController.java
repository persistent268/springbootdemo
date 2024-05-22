package cn.devcorp.demo.controller;

import cn.devcorp.demo.service.StudentsService;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/23 16:14
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController
public class CompleController {
    @Resource
    private StudentsService service;

    @GetMapping("/com")
    public void com() throws InterruptedException {
        String result = "";
        result = service.add();
        throw  new RuntimeException();
//        String finalResult = result;
//        CompletableFuture.runAsync(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println(2);
//                    }
//                }
//        );

//        CompletableFuture.runAsync(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                        System.out.println(222);
//
//                    }
//                }
//        );
    }
}
