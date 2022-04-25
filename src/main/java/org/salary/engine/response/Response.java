package org.salary.engine.response;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaoyunxing
 * @date 2022-04-25 19:32:14
 */
@Getter
@Setter
@RegisterForReflection
public class Response<T> {

    private T data;

    /**
     * 请求是否成功标志位
     */
    private boolean success;

    /**
     * 响应编码
     */
    private int code;

    /**
     * 响应具体信息
     */
    private String msg;

    public static <T> Response<T> getSuccess(T data) {
        Response<T> res = new Response<T>();
        res.setSuccess(true);
        res.setData(data);
        res.setCode(200);
        res.setMsg("ok");
        return res;
    }

    public static <T> Response<T> getSuccess() {
        Response<T> res = new Response<T>();
        res.setSuccess(true);
        res.setCode(200);
        res.setMsg("ok");
        return res;
    }
}
