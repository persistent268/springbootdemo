package cn.devcorp.demo.pojo;

import lombok.Data;
import lombok.Getter;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/5 16:15
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Getter
public class SignTaskDto {
    private String taskName;
    private Integer signType;

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setSignType(Integer signType) {
        this.signType = signType + 100;
    }
}
