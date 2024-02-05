package cn.devcorp.demo.pojo;

import cn.devcorp.demo.enums.SignMethodInnerEnum;
import cn.devcorp.demo.utils.ValidatorUtils;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/27 14:48
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@Builder
public class SignTaskDocument {
    @Tolerate
    public SignTaskDocument(){}
    private List<SignTaskDocDocument> fileList;
    private String taskName;
}
