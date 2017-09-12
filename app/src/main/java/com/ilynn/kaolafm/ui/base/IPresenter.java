package com.ilynn.kaolafm.ui.base;

/**
 * 描述：mvp presenter
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午4:47
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface IPresenter<V extends IView> {
    /**
     * 关联p与v
     *
     * @param view IView
     */
    void attachView(V view);

    /**
     * 取消关联p与v
     */
    void detachView();
}
