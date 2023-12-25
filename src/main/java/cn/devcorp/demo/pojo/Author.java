package cn.devcorp.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/12 14:48
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author{
    private String name;
    private Integer age;
}
