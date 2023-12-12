package cn.devcorp.demo.enums;

/**
 * @ClassName SignTypeEnum
 * @Description 签章类型枚举类
 * @Author yk.zlf
 * @Date 2023/11/14 10:00
 */
public enum SignTypeEnum {

    UNIT(1, "单位"),
    PERSONAL(2, "个人"),
    UNIT_PERSONAL(3, "单位、个人");

    private Integer code;
    private String message;

    SignTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    public static String meaning(Integer signType) {
        if(null != signType) {
            for (SignTypeEnum value : SignTypeEnum.values()) {
                if(value.getCode().equals(signType)) {
                    return value.getMessage();
                }
            }
        }
        return "-";
    }
}