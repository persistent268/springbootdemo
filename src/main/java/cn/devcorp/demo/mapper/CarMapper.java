package cn.devcorp.demo.mapper;

import cn.devcorp.demo.pojo.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/3/9 15:39
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public interface CarMapper extends BaseMapper<Car> {
    Map<String, Object> selectOneMap(@Param("brand") String brand);

    List<Map<String, Object>> selectMoreMap();
    @MapKey("id")
    Map<Long,Map<String, Object>> selectMapMap();
}
