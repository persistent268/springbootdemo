package cn.devcorp.demo.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/27 14:49
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@Builder
public class SignTaskDocDocument {
    @Tolerate
    public SignTaskDocDocument(){}
    private Integer signMethod;
    private String fileName;
}
