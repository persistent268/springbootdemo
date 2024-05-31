package cn.devcorp.demo.pojo;

import lombok.Data;

import java.util.List;
@Data
public class PaymentHackData {
    private String subtotal;
    private String tax;
    private String transform;
    private String other;
    private String unpay;
    private String total;

    private List<Goods> goods;
    private List<Goods> goods2;
    private List<Labor> labors;
    private List<Labor> labors2;
}