package com.rbac.rbacService.commen.response;

import lombok.Getter;

/**
 * @author  梁家宝
 * @description  响应码
 */
@Getter
public enum RespondeCode {

    SUCCESS(20000, "操作成功"),
    FAILED(10000, "响应失败"),
    VALIDATE_FAILED(10001, "参数校验失败"),
    LOGIN_FAILED(10002, "登录失败"),
    NO_PERMISSION_FAILED(10003, "权限校验失败"),
    ERROR(50000, "未知错误");

    private int code;
    private String message;

    RespondeCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
