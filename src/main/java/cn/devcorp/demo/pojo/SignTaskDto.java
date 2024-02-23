package cn.devcorp.demo.pojo;

import lombok.Data;
import lombok.Getter;

import java.util.List;

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
@Data
public class SignTaskDto {
    private String taskName;
    private Integer signType;
    private List<SignTaskDocument> fileList;

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setSignType(Integer signType) {
        this.signType = signType + 100;
    }
}
