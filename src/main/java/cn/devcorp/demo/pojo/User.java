package cn.devcorp.demo.pojo;

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
    private List<Order> orderList;
}