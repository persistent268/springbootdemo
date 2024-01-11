package cn.devcorp.demo.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/11 11:25
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
public class ResultVo<T> {
    private Boolean success = true;
    private T data;
    public static<T> ResultVo<T> buildSuccess(T data){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setData(data);
        return resultVo;
    }
}
