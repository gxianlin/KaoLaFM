package com.ilynn.base.http;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午1:19
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class OkHttpException extends Exception {
    private int ecode;
    private Object emsg;

    public OkHttpException(int ecode, Object emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode() {
        return ecode;
    }

    public Object getEmsg() {
        return emsg;
    }
}
