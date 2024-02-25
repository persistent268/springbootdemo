package cn.devcorp.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/10 13:47
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@ToString
@TableName(value = "`order`")
public class Order {
    private Long id;
    private LocalDateTime orderTime;
    private Double total;
}
