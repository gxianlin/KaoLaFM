package com.ilynn.base.http;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午1:23
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class DisposeHandler {

    public DisposeListener mListener;

    public Class<?> mClass;

    public DisposeHandler(DisposeListener listener) {
        mListener = listener;
    }

    public DisposeHandler(DisposeListener listener, Class<?> aClass) {
        mListener = listener;
        mClass = aClass;
    }


}
