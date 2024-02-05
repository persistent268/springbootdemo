package cn.devcorp.demo.vo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

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
 @Data
 @Builder
public class SignTaskDocDocumentVo {
  @Tolerate
  public SignTaskDocDocumentVo(){}
  private Integer signMethod;
  private String fileName;
}
