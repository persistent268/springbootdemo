package cn.devcorp.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description:es mapping结构
 *
 * @author yk074
 * @date 2023/1/4 10:59
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EsMappingModel {

    /**
     * 流水号
     */
    private Long taskId;

    /**
     * 组织机构id
     */
    private Long orgId;
    /**
     * 印章编码
     */
    private String esealCode;
    /**
     * 印章名称
     */
    private String esealName;
    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 租户name
     */
    private String tenantName;
    /**
     * 文件id
     */
    private String fileObjectId;
    /**
     * 用印主体 1：内部单位，2：内部个人，3：外部单位，4：外部个人
     */
    private int signType;
    /**
     * 用印方式 1自动用印；2拖拽用印 3手写签名
     */
    private int signMethod;
    /**
     * 用印人
     */
    private String userId;
    /**
     * 用印人name
     */
    private String userName;
    /**
     * 1内部2.外部
     */
    private int userType;
    /**
     * 用印时间-年
     */
    private String timeYear;

    /**
     * 用印时间-月
     */
    private String timeMonth;
    /**
     * 用印时间-日
     */
    private String timeDay;
    /**
     * 用印时间-时
     */
    private String timeHour;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 证书类型
     */
    private int certType;

    /**
     * 创建时间
     */
    private Date createTime;

}
