package com.example.base;


import lombok.Getter;
import lombok.Setter;

/**
 * @author mojinpeng
 */

public enum ResultCode {
    /**
     * 常见的结果
     */
    SUCCESS(1, "成功"),
    ERROR(-1,"操作失败"),
    NET_ERROR(500,"服务器内部错误");
    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String message;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
