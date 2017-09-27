package com.ilynn.kaolafm.api;

import java.io.Serializable;

/**
 * 自定义异常类
 *
 * @author gong.xl
 * @version 1.0.0
 * @date 2017/4/13  10:19
 * @copyright wonhigh.cn
 */
public class ApiException extends RuntimeException implements Serializable {

    //返回码类型,根据接口返回类型定义和区分
    public static final String SUCCESS = "10000";

    private String code;
    private String message;

    public ApiException(String resultCode, String message) {
        super(message);
        this.code = resultCode;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
