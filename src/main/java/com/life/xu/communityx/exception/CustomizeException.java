package com.life.xu.communityx.exception;

/**
 * @program: communityx
 * @description: 自定义异常
 * @author: Mr.Xu
 * @create: 2019-10-22 10:33
 **/
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
