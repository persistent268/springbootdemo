package cn.devcorp.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Students {
    private Long id;
    private String studentName;
    private String subject;
    private Integer score;
}
