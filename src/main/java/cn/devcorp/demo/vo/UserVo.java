package cn.devcorp.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/16 21:15
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
public class UserVo {
    @NotNull
    private String name;
    @NotNull
    private String password;
    private List<UserResponseVo> userResponseVo;
    public String getSex(){
        return "男";
    }
}
