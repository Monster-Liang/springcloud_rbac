package com.rbac.rbacService.commen.response;

import lombok.Getter;

/**
 * @author  梁家宝
 * @description
 */
@Getter
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public Response(T data) {
        this(RespondeCode.SUCCESS, data);
    }

    public Response(RespondeCode respondeCode, T data) {
        this.code = respondeCode.getCode();
        this.message = respondeCode.getMessage();
        this.data = data;
    }

    public static Response sucess(){
        return new Response(null);
    };
}
