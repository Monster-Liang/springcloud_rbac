package com.rbac.rbacService.exception;


/**
 * @author 梁家宝
 * @description 定义出现的异常和异常状态码
 */

public enum ExceptionType {
    //状态码和异常描述
    SYSTEM_ERROR(10001, "系统出现错误,请稍后再试！"),
    NoPermissionException(10002,"无权限异常"),
    OTHER_ERROR(10003, "出现其他异常,请稍后再试！");


    private int code;
    private String description;
    ExceptionType(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode(){
        return code;
    }
    public String getDesription(){
        return description;
    }
}
