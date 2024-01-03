package cn.devcorp.demo.vo;

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
@Schema(description = "租户管理员账号信息")
public class TenantAdminsVo {
    @Tolerate
    public TenantAdminsVo(){}
    @Schema(description = "邮件信息")
    private String email;
    @Schema(description = "租户成员信息")
    private String username;
}
