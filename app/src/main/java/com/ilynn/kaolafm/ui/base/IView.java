package com.ilynn.kaolafm.ui.base;

import android.content.Context;

/**
 * 描述：mvp view
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午4:34
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface IView {
    Context getContext();

    /**
     * 显示加载动画
     */
    void showProgress();

    /**
     * 隐藏加载动画
     */
    void hideProgress();

    /**
     * 显示加载失败
     *
     * @param code    返回码
     * @param message 错误信息
     */
    void showFail(int code, String message);
}
