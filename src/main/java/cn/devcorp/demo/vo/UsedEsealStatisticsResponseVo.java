package cn.devcorp.demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.Map;

/**
 * @ClassName UsedEsealStatisticsReponseVo
 * @Description 用印统计接口返回参数
 * @Author yk.zlf
 * @Date 2024/1/17 18:14
 */
@Data
@Builder
@Schema(name = "用印统计接口返回参数", description = "用印统计接口返回参数")
public class UsedEsealStatisticsResponseVo implements Serializable {

    @Tolerate
    public UsedEsealStatisticsResponseVo() {

    }

    @Schema(title = "统计图表")
    private Map<String, Long> statisticalChartMap;

    @Schema(title = "趋势")
    private Map<String, Map<String, Long>> esealStatisticsMap;


//    @Schema(title = "印章统计")
//    private List<EsealStatisticsResponseVo> esealStatisticsResponseVoList;


}
