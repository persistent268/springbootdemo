package cn.devcorp.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/3/9 15:35
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@TableName(value = "t_car")
public class Car {
    private Long id;
    @TableField(value = "car_num")
    private String carNum;
    private String brand;
    @TableField(value = "guide_price")
    private Double guidePrice;
    @TableField(value = "produce_time")
    private String produceTime;
    @TableField(value = "car_type")
    private String carType;
}
