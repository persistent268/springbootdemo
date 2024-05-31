package cn.devcorp.demo.pojo;

import lombok.Data;

@Data
public class Goods {
  private int count;
  private String name;
  private String desc;
  private int discount;
  private int tax;
  private int price;
  private int totalPrice;
  // getter setter
}