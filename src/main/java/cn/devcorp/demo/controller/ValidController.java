package cn.devcorp.demo.controller;

import cn.devcorp.demo.pojo.Tenant;
import cn.devcorp.demo.result.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/4 15:16
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController
public class ValidController {
    @PostMapping("/valid")
    public JsonResult<Tenant> valid(@Valid @RequestBody Tenant tenant){
        return JsonResult.getInstant(200,"校验入参",tenant);
    }
}
