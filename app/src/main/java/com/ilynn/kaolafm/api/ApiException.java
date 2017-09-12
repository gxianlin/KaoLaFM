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
public class ApiException extends RuntimeException implements Serializable{

    //返回码类型
    public static final String SUCCESS = "10000";
    public static final int ERROR = -1;
    public static final int NO_DATA = 5;
    public static final int NO_FUNCTION_PERMISSION = 2;
    public static final int NO_DATA_PERMISSION = 3;
    public static final int JSON_ERROR = 4;
    public static final int TOKEN_FAILURE = 10;
    public static final int OTHER_LOGIN = 11;
    public static final int ACCOUNT_CHANGE = 12;
    public static final int UNKNOWN_ERROR = 99;

    public static final String JSON_HINT = "服务器返回json数据异常";
    public static final String NODATA_HINT = "暂时没有数据";
    public static final String NO_CONTENT_HINT = "没有相关内容";
    public static final String OUTTIME_HINT = "请求超时啦,请检查网络或刷新";
    public static final String NONETWORK_HINT = "网络不稳定，请检查网络或刷新";
    public static final String OTHER_HINT = "页面出错啦~再下拉刷新试试";



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
