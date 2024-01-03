package cn.devcorp.demo.controller;

import cn.devcorp.demo.pojo.Users;
import cn.devcorp.demo.result.JsonResult;
import org.springframework.web.bind.annotation.*;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/28 15:47
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController
public class UserController2 {
    @GetMapping("/test")
    public JsonResult test(@RequestParam String m1){
        return JsonResult.getInstant(200,"成功");
    }
   @PostMapping("/user")
    public JsonResult getUser(@RequestBody Users users){
       System.out.println(users);
       return JsonResult.getInstant(200,"成功",users);
   }
}
