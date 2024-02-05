package cn.devcorp.demo.controller;

import cn.devcorp.demo.enums.ReturnCodeEnum;
import cn.devcorp.demo.result.GeneralCode;
import cn.devcorp.demo.result.JsonResult;
import cn.devcorp.demo.vo.UserResponseVo;
import cn.devcorp.demo.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/2/3 14:54
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController
public class JsonController {
    @GetMapping("/json")
    public JsonResult<UserVo> listUser(){
        UserVo userVo = new UserVo();
        userVo.setName("zhang");
        userVo.setPassword("li");
        UserResponseVo userResponseVo = new UserResponseVo();
        userResponseVo.setName("li");
        userResponseVo.setAge(18);
        userVo.setUserResponseVo(Arrays.asList(userResponseVo));
        return JsonResult.getInstant(ReturnCodeEnum.SUCCESS,userVo);
    }
}
