package cn.devcorp.demo.pojo;

import lombok.Builder;
import lombok.ToString;

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
@ToString
public class Person {
    private String name;
    private Integer age;
    private String address;
}
