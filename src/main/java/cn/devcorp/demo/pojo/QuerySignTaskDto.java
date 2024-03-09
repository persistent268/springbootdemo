package cn.devcorp.demo.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/3/1 14:14
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@Builder
public class QuerySignTaskDto {
    @Tolerate
    public QuerySignTaskDto(){}
    private Long taskId;
}
