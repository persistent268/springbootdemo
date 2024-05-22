package cn.devcorp.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/5/6 18:19
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stu {
    private Long id;
    private Date entryTime;
}
