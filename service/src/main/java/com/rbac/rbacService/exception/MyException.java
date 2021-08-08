package com.rbac.rbacService.exception;

/**
 * @author 梁家宝
 * @description 自定义出现的异常
 */
public class MyException extends RuntimeException{
    private final int code;
    private final String message;

    public MyException(ExceptionType exception){
        this.code = exception.getCode();
        this.message = exception.getDesription();
    }
    public MyException(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
