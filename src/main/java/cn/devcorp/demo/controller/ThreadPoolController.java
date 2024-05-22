package cn.devcorp.demo.controller;

import cn.devcorp.demo.result.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/4/12 19:36
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController
public class ThreadPoolController {
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.AbortPolicy());
    @GetMapping("testExcute")
    public JsonResult<Void> testExcute(){
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("执行一个异步任务");
            }
        });
        return JsonResult.getInstant(1,"测试");
    }

}
