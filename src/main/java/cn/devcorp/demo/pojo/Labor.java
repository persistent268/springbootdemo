package cn.devcorp.demo.pojo;

import lombok.Data;

@Data
public class Labor {
  private String category;
  private int people;
  private int price;
  private int totalPrice;
  // getter setter
}