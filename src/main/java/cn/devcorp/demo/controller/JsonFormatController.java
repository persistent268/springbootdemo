package cn.devcorp.demo.controller;

import cn.devcorp.demo.vo.UploadInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/5/19 13:14
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController
public class JsonFormatController {
    @PostMapping("query")
    public void json(@RequestBody UploadInfo uploadInfo){
        System.out.println(uploadInfo);
    }
}
