package cn.devcorp.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/5 10:24
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    private String phoneName;
    private Integer no;

    @Override
    public String toString() {
        return "Phone{" +
                "phoneName='" + phoneName + '\'' +
                ", no=" + no +
                '}';
    }
}
