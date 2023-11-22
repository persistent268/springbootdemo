package cn.devcorp.demo.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/19 15:12
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@ToString
public class Students {
    private Integer studentId;
    private String studentName;
    private String subject;
    private Integer score;
}
