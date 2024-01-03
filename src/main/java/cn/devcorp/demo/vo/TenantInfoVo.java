package cn.devcorp.demo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/28 11:24
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
@Builder
@Schema(description = "租户信息")
public class TenantInfoVo {
    @Tolerate
    public TenantInfoVo(){}
    @Schema(title = "租户名称")
    @TableField("tenant_name")
    private String tenantName;

    @Schema(title = "租户编码code")
    @TableField("tenant_code")
    private String tenantCode;

    @Schema(title = "租户key")
    @TableField("tenant_key")
    private String tenantKey;

    @Schema(title = "租户状态（0禁用；1启用）")
    @TableField("tenant_status")
    private Integer tenantStatus;

    @Schema(title = "租户创建api网关对应id")
    @TableField("app_id")
    private String appId;

    @Schema(title = "创建租户api网关返回appcode")
    @TableField("app_code")
    private String appCode;

    @Schema(title = "租户创建api网关对应appKey")
    @TableField("app_key")
    private String appKey;

    @Schema(title = "创建租户管理员账号")
    @TableField("creator")
    private String creator;

    @Schema(title = "更新租户管理员账号")
    @TableField("updater")
    private String updater;
}
