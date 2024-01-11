package cn.devcorp.demo.pojo;

import lombok.Data;

import java.lang.reflect.Type;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/11 11:09
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
public abstract class AnnoyClass {
    private String name;
    private Integer age;
    public abstract void study();
    public AnnoyClass(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
}
