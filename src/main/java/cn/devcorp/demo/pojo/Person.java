package cn.devcorp.demo.pojo;

import lombok.*;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/26 21:04
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String address;
}
