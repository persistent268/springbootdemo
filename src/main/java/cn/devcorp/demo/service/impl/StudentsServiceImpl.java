package cn.devcorp.demo.service.impl;

import cn.devcorp.demo.mapper.StudentsMapper;
import cn.devcorp.demo.pojo.Students;
import cn.devcorp.demo.service.StudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/19 15:15
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {
}
