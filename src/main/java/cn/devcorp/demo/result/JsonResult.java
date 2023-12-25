package cn.devcorp.demo.result;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JsonResult<T> implements Serializable {

   private static final long serialVersionUID = 1L;

   /**
    * 返回代号
    */
   private Integer code;
   /**
    *返回信息
    */
   private String message;
   /**
    *返回数据
    */
   private T data;



   /**
    * Description:
    * <实例一个JsonResult>
    * @author wupanhua
    * @date 13:43 2019/8/8
    * @param code 1
    * @param msg 2
    * @param data 3
    * @return JsonResult
    **/
   public static <T> JsonResult<T> getInstant(Integer code, String msg, T data) {
      return new JsonResult<>(code, msg, data);
   }

   /**
    * Description:
    * <实例个JsonResult>
    * @author wupanhua
    * @date 13:43 2019/8/8
    * @param generalCode 1
    * @param data 2
    * @return JsonResult
    **/
   public static <T> JsonResult<T> getInstant(GeneralCode generalCode, T data) {
      return new JsonResult<>(generalCode.getCode(), generalCode.getMsg(), data);
   }

   /**
    * Description:
    * <实例一个JsonResult>
    * @author wupanhua
    * @date 13:44 2019/8/8
    * @param code 1
    * @param msg 2
    * @return JsonResult
    **/
   public static <T> JsonResult<T> getInstant(Integer code, String msg) {
      return new JsonResult<>(code,msg);
   }
   private JsonResult(Integer code, String msg, T data) {
      this.code = code;
      this.message = msg;
      this.data = data;
   }

   private JsonResult(Integer code, String msg) {
      this.code = code;
      this.message = msg;
   }

   @Override
   public String toString() {
      return JSON.toJSONString(this);
   }
}