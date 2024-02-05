package cn.devcorp.demo.vo;

import cn.devcorp.demo.enums.SignMethodInnerEnum;
import cn.devcorp.demo.pojo.SignTaskDocDocument;
import cn.devcorp.demo.pojo.SignTaskDocument;
import cn.devcorp.demo.utils.BeanUtils;
import cn.devcorp.demo.utils.ValidatorUtils;
import com.google.common.collect.Lists;
import lombok.*;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/27 14:59
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Getter
@Setter
@ToString(doNotUseGetters = true)
@Builder
public class SignTaskDocumentVo {
    @Tolerate
    public SignTaskDocumentVo(){}
    private Integer signMethod;
    private List<SignTaskDocDocumentVo> fileList;
    private String taskName;
    public List<SignTaskDocDocumentVo> getFileList(){
        return BeanUtils.copyList(fileList, SignTaskDocDocumentVo.class);
    }
    public Integer getSignMethod() {
        Integer signMethod = null;
        if (ValidatorUtils.isEmpty(getFileList())) {
            return signMethod;
        }
        Set<Integer> signMethodSet = new HashSet<>();
        for (SignTaskDocDocumentVo signTaskDocDocumentVo : getFileList()) {
            SignMethodInnerEnum enumByCode = SignMethodInnerEnum.getEnumByCode(signTaskDocDocumentVo.getSignMethod());
            if (ValidatorUtils.isEmpty(enumByCode)) {
                continue;
            }
            switch (enumByCode) {
                case AUTO:
                    signMethodSet.add(SignMethodInnerEnum.AUTO.getCode());
                    break;
                case DRAG:
                    signMethodSet.add(SignMethodInnerEnum.DRAG.getCode());
                    break;
                case AUTO_DRAG:
                    signMethodSet.add(SignMethodInnerEnum.AUTO.getCode());
                    signMethodSet.add(SignMethodInnerEnum.DRAG.getCode());
                    break;
            }
        }
        if (signMethodSet.contains(SignMethodInnerEnum.AUTO.getCode()) && signMethodSet.contains(SignMethodInnerEnum.DRAG.getCode())) {
            signMethod = SignMethodInnerEnum.AUTO_DRAG.getCode();
        } else if (signMethodSet.size() > 0) {
            ArrayList<Integer> integers = Lists.newArrayList(signMethodSet);
            signMethod = integers.get(0);
        }
        return signMethod;
    }
    public String getSignMethodStr(){
        return SignMethodInnerEnum.meaning(signMethod);
    }
}
