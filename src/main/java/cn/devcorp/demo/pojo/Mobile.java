package cn.devcorp.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/5 10:26
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {
    private String phoneName;
    private Integer no;

    @Override
    public String toString() {
        return "Mobile{" +
                "phoneName='" + phoneName + '\'' +
                ", no=" + no +
                '}';
    }
}
