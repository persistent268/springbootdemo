package cn.devcorp.demo.mapper;

import cn.devcorp.demo.pojo.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/10 15:32
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public interface BookMapper extends BaseMapper<Book> {
    List<Book> queryBookAndCategory();
}
