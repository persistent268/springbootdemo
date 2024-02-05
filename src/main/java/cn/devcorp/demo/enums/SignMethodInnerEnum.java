package cn.devcorp.demo.enums;

import cn.devcorp.demo.utils.ValidatorUtils;

/**
 * Description: copy from 内部签章
 *
 * @author YK107
 * @date 2024/1/24 11:30
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public enum SignMethodInnerEnum {
    AUTO(1, "自动"),
    DRAG(2, "拖放"),
    AUTO_DRAG(3, "自动+拖放"),

            ;

    private Integer code;
    private String message;

    SignMethodInnerEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    public static String meaning(Integer signMethod) {
        if(null != signMethod) {
            for (SignMethodInnerEnum value : SignMethodInnerEnum.values()) {
                if(value.getCode().equals(signMethod)) {
                    return value.getMessage();
                }
            }
        }
        return "-";
    }

    public static SignMethodInnerEnum getEnumByCode(Integer code) {
        if (ValidatorUtils.isEmpty(code)) {
            return null;
        }
        for (SignMethodInnerEnum value :
                SignMethodInnerEnum.values()) {
            if (code.equals(value.getCode())) {
                return value;
            }
        }
        return null;
    }
}
