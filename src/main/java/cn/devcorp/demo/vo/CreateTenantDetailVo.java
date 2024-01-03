package cn.devcorp.demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@Schema(description = "创建租户详情Vo")
public class CreateTenantDetailVo {
    @Tolerate
    public CreateTenantDetailVo(){}
    @Schema(description = "租户信息Vo")
    private TenantInfoVo tenantInfoVo;
    @Schema(description = "印章类型白名单、文件类型白名单、签章机构白名单")
    private WhiteListValueVo whiteListValueVo;
    @Schema(description = "租户管理员账号信息")
    private TenantAdminsVo tenantAdminsVo;
}