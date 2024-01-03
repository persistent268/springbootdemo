package cn.devcorp.demo.controller;

import cn.devcorp.demo.enums.ReturnCodeEnum;
import cn.devcorp.demo.exception.BusinessException;
import cn.devcorp.demo.pojo.User;
import cn.devcorp.demo.result.GeneralCode;
import cn.devcorp.demo.result.JsonResult;
import cn.devcorp.demo.vo.UserResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/3 9:24
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public JsonResult<UserResponseVo> hello(){
        User user = new User();
        user.setName("张三");
        user.setAge(10);
        UserResponseVo userResponseVo = new UserResponseVo();
        BeanUtils.copyProperties(user,userResponseVo);
        if(user.getId() == null){
            throw new BusinessException(ReturnCodeEnum.SYSTEM_ERROR.getMsg(), ReturnCodeEnum.SYSTEM_ERROR.getCode());
        }
        return JsonResult.getInstant(200,"响应成功",userResponseVo);
    }
}
