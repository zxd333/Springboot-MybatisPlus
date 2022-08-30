package org.demo.result;

import lombok.Data;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 状态码
    private Integer code;

    // 信息
    private String message;

    // 成功标志
    private Boolean success;

    // 数据
    private T data;

    // 成功，写成静态的直接让外部调用，不用 new 了
    public static<T> Result<T> ok(T data){
        Result<T> r = new Result<T>();

        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMessage(ResultCode.SUCCESS.getMessage());
        r.setSuccess(ResultCode.SUCCESS.getSuccess());
        r.setData(data);

        return r;
    }

    // 失败
    public static<T> Result<T> error(String message){
        return error(ResultCode.ERROR.getCode(), message);
    }

    public static<T> Result<T> error(Integer code, String message){
        return error(code, message, null);
    }

    public static<T> Result<T> error(Integer code, String message, T data){
        Result<T> r = new Result<T>();

        r.setCode(code);
        r.setMessage(message);
        r.setSuccess(false);

        if (data != null) {
            r.setData(data);
        }

        return r;
    }
}
