package cn.devcorp.demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Schema(description = "创建租户信息Vo,action为请求路径")
public class CreateTenantRequestVo {
    @Tolerate
    public CreateTenantRequestVo(){}
    @Schema(description = "创建租户详情Vo")
    private CreateTenantDetailVo createTenantDetailVo;
}