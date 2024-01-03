package cn.devcorp.demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.List;

/**
 * Description: 白名单Vo
 *
 * @author YK107
 * @date 2023/12/28 11:24
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Schema(description = "印章类型白名单、文件类型白名单、签章机构白名单")
@Data
@Builder
public class WhiteListValueVo {
    @Tolerate
    public WhiteListValueVo(){}
    @Schema(description = "签章机构白名单")
    private List<String> signOrg;
    @Schema(description = "文件类型白名单")
    private List<String> fileType;
    @Schema(description = "印章类型白名单")
    private List<String> sealType;
}
