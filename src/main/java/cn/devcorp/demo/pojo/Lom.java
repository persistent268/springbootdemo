package cn.devcorp.demo.pojo;

import lombok.*;
import lombok.experimental.Tolerate;

import java.util.Objects;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/10 13:01
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public class Lom {
    private String name;
    private Long parentid;

    public Long getParentid() {
        return parentid;
    }
}
