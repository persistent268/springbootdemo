package cn.devcorp.demo.pojo;

import lombok.Data;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/5 16:14
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
public class SignTask {
    private String taskName;
    private Integer signType;
    public Integer getSignType(){
        return this.signType + 10;
    }
}
