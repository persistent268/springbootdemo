package cn.devcorp.demo.enums;

import cn.devcorp.demo.result.GeneralCode;

/**
 * Description: ReturnCodeEnum
 *
 * @author wupanhua
 * @date 2019/8/6 15:28
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public enum ReturnCodeEnum implements GeneralCode {

    /**
     * 系统错误码
     */
    SUCCESS(200, "执行成功"),
    REQUEST_ERROR(999, "执行失败"),
    PARAMETER_NOT_MATCH(204, "参数列表错误(缺少或格式不匹配)"),
    UNAUTHORIZED(401, "未授权"),
    RESOURCE_NOT_FOUND(404, "资源不存在或不可用"),
    OVERLOAD(503, "服务器拥挤，让我休息一会儿吧～"),
    PERMISSION_DENIED(403, "访问受限"),
    CURRENT_ELEMENT_WAS_OCCUPIED(409, "资源冲突或被锁定"),
    SYSTEM_ERROR(500, "系统异常"),
    TOKEN_INVALID(600, "身份令牌缺失或已失效，请重新登录"),
    TOKEN_STOLEN(601, "当前账号在其他设备上登录。"),
    ERROR(999, "执行失败"),
    SUCCESS_USER(1000, "执行成功"),
    /**
     * 业务错误码 100-200
     */
    LOGIN_FAIL(100, "用户名或密码错误"),
    USER_NOT_IN_SESSION(101, "SESSION中不存在当前用户"),
    VALIDATE_CODE_WRONG(102, "验证码错误"),
    USER_LOCKED(103, "用户被锁定"),
    EMAIL_EXIST(105, "邮箱已存在"),
    USERNAME_EXISTS(106, "账号已存在"),
    DELETE_POSITION_ERROR(998, "该职位已绑定成员，不可删除"),
    DELETE_DEPARTMENT_ERROR(998, "该部门已绑定成员，不可删除"),
    DELETE_DEPARTMENT_LOWER_ERROR(998, "下属部门已绑定成员，不可删除"),
    DELETE_TENANT_ROLE_ERROR(998, "该角色已绑定成员，不可删除"),
    DELETE_TENANT_ROLE_DEFAULT_ERROR(998, "该角色是默认角色，不可删除"),
    MODEL_ERROR(901,"您选择的能力维度题库题量较少，不满足当前模型的权重要求"),

    /**
     * 支付相关错误码 1000-1999
     */
    INSUFFICIENT_ACCOUNT_BALANCE(1000, "账户余额不足，请及时充值！"),
    /**
     * 考试认证相关
     **/
    MOBILE_OR_EMAIL_NOT_NULL(601, "请输入您的手机号或邮箱"),
    INVITE_CODE_NOT_NULL(602, "请输入您的邀请码"),
    INVITE_CODE_NOT_EXIST(602, "请确认您的邀请码是否正确"),
    EMAIL_NOT_EXIST(603, "您输入的邮箱不存在"),
    MOBILE_NOT_EXIST(604, "您输入的手机号不存在"),
    MOBILE_NOT_NULL(604, "请输入您的手机号"),
    EMAIL_NOT_NULL(605, "请输入您的邮箱不"),
    REAL_NAME_NOT_NULL(605, "请输入您的真实姓名"),
    PAPER_ERROR(606,"试卷可能正在生成，请稍等片刻"),
    BEYOND_MAX_PERSON_NUMBER(607,"当前考场考试人数已达上限，请联系考试发起人"),
    PARTICIPANT_NOT_EXIST(608, "您的参试人信息不存在，请联系考试发起人"),
    EXAMINATION_NOT_EXIST(609, "未查询到有效的考试信息，请联系考试发起人"),
    ;

    private final Integer code;
    private final String msg;

    ReturnCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    @Override
    public String getMsg() {
        return msg;
    }
}
