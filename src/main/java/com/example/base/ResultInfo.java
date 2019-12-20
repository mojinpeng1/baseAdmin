package com.example.base;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description：返回结果</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/18 9:12
 */
@Data
public class ResultInfo implements Serializable {
    /**
     * 返回信息代码（1 成功  -1 失败）
     */
    private Integer code;
    /**
     * 返回接口调用消息提示，成功返回success，失败返回对应的失败信息
     */
    private String msg;
    /**
     * 返回的执行结果集
     */
    private Object data;

    public static ResultInfo success(){
        return new ResultInfo(ResultCode.SUCCESS);
    }

    public static ResultInfo success(Object data) {
        ResultInfo resultInfo = success();
        resultInfo.data = data;
        return resultInfo;
    }

    public  static ResultInfo error(){
        return  new ResultInfo(ResultCode.ERROR);
    }
    public static ResultInfo error(String msg) {
        ResultInfo resultInfo = error();
        resultInfo.setMsg(msg);
        return resultInfo;
    }


    public ResultInfo(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.data= null;
    }
}