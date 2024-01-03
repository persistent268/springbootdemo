package cn.devcorp.demo.exception;

import cn.devcorp.demo.enums.ReturnCodeEnum;
import cn.devcorp.demo.result.GeneralCode;

public class BusinessException extends RuntimeException {
    private final Integer code;

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
        this.code = ReturnCodeEnum.ERROR.getCode();
    }

    public BusinessException(GeneralCode dady) {
        this(dady.getMsg(), dady.getCode());
    }

    /**
     * Description:
     * <a general exception>
     * @author wenxiaopeng
     * @date 15:50 2020/04/09
     * @return
     **/
    public BusinessException() {
        this(ReturnCodeEnum.ERROR);
    }

    public Integer getCode() {
        return code;
    }
}