package com.ilynn.kaolafm.bean;

/**
 * 描述：服务接口返回公共字段
 * <p>
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 22:40
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class BaseResult<T> {
    private String code;
    private String message;
    private T result;
    private long serverTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
