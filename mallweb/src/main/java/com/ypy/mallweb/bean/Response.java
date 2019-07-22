package com.ypy.mallweb.bean;

import lombok.Data;

@Data
public class Response {

    /**
     * 返回响应编码：200表示成功 500表示失败
     */
    private String code;
    /**
     * 返回响应描述
     */
    private String msg;
    /**
     * 返回结果
     */
    private Object data;

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
