package cn.devcorp.demo.utils;

import cn.devcorp.demo.pojo.SignTask;
import cn.devcorp.demo.pojo.SignTaskDto;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/5 16:26
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public class BeanUtilsMy {
    public static SignTaskDto copyProperties(SignTask source,SignTaskDto target){
        //获取target里的所有属性,即taskName,signType.依次赋值给source里相应的属性
        //遍历target类里的所有属性
        //在赋值时,需要判断当前属性在source里是否存在,如果不存在不赋值,存在调用相同名字属性set方法赋值
          /*
        判断target里是否包含taskName属性
        if(){

            }
         */
        //取值
        String taskName = source.getTaskName();
       //赋值
        target.setTaskName(taskName);
        //-------------------------
        Integer signType = source.getSignType();
        target.setSignType(signType);
        return target;
    }
}
