package cn.devcorp.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
    private String gender;
    @TableField(exist = false)
    private List<Order> orderList;
    @TableField("deleted")
    private Integer deleted;
}