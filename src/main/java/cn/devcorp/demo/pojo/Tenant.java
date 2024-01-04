package cn.devcorp.demo.pojo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/4 15:19
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
public class Tenant {
    @NotNull
    private String tenantName;
    private Integer tenantId;
    @Valid
    private List<TenantMember> tenantMemberList;
}
