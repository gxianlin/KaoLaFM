package com.ilynn.kaolafm.okhttp;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午2:57
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class RequestParam {
    private String key;
    private Object value;

    public RequestParam(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
