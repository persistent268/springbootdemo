package cn.devcorp.demo.mapper;

import cn.devcorp.demo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/25 11:49
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> queryUserByWhere(User user);
    List<User> queryUserByWhere2(User user);
    User queryUserOrders(@Param("id") Long id);

    User selectByIdDefine(@Param("id") Long id);

    User queryUserOneByWhere(User userVo);

    String selectByDe(String sfl);
}
