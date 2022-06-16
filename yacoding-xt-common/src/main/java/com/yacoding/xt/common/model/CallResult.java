package com.yacoding.xt.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jarno
 */
@Data//
@AllArgsConstructor//所有构造器
@NoArgsConstructor//无参构造器
@Builder//传递一个对象CallResult
public class CallResult<T> implements Serializable {

    private int code;//代码信息

    private String message;//给与错误信息

    private T result;//返回值

    public static <T>CallResult<T> success() {
        return new CallResult<T>(BusinessCodeEnum.DEFAULT_SUCCESS.getCode(), BusinessCodeEnum.DEFAULT_SUCCESS.getMsg(), null);
    }

    public static <T>CallResult<T> success(T result) {
        return new CallResult<T>(BusinessCodeEnum.DEFAULT_SUCCESS.getCode(), BusinessCodeEnum.DEFAULT_SUCCESS.getMsg(), result);
    }
    public static <T>CallResult<T> success(int code, String message,T result) {
        return new CallResult<T>(code, message, result);
    }

    public static <T>CallResult<T> fail() {
        return new CallResult<T>(BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(), BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg(), null);
    }
    public static <T>CallResult<T> fail(T result) {
        return new CallResult<T>(BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(), BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg(), result);
    }

    public static <T>CallResult<T> fail(int code, String message) {
        return new CallResult<T>(code, message, null);
    }

    public static <T>CallResult<T> fail(int code, String message, T result) {
        return new CallResult<T>(code, message, result);
    }

    public  boolean isSuccess(){
        return this.code == BusinessCodeEnum.DEFAULT_SUCCESS.getCode();
    }
}
