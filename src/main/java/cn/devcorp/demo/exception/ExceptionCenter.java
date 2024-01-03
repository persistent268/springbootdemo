package cn.devcorp.demo.exception;

import cn.devcorp.demo.enums.ReturnCodeEnum;
import cn.devcorp.demo.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionCenter {
    /**
     * Description:
     * <捕捉校验异常>
     * @author wupanhua
     * @date 15:18 2019/8/8
     * @param ex 1
     * @return JsonResult
     **/
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult<Map<String, String>> validateException(MethodArgumentNotValidException ex){

        // 打印出错误信息
        Map<String, String> result = new HashMap<>();
        BindingResult bindingResult = ex.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            allErrors.forEach(error -> {
                FieldError fieldError = (FieldError) error;
                result.put(fieldError.getField(), fieldError.getDefaultMessage());
                log.error("Validate Error: Object: {}, Filed: {}, ErrorMessage: {}", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            });
        }

        return JsonResult.getInstant(ReturnCodeEnum.PARAMETER_NOT_MATCH, result);
    }
    /**
     * Description:
     * <业务异常>
     * @author wupanhua
     * @date 15:18 2019/8/8
     * @param e 1
     * @return JsonResult
     **/
    @ResponseBody
    @ExceptionHandler(value = {BusinessException.class})
    public JsonResult<String> businessException(BusinessException e) {
        log.error("业务异常", e);
        return JsonResult.getInstant(e.getCode(), e.getMessage());
    }
}
