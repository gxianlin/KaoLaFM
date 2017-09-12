package com.ilynn.kaolafm.ui.base;

import com.ilynn.kaolafm.api.ApiCallBack;

import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午4:50
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class BasePresenter<V extends IView> implements IPresenter<V>,IModel {
    protected V mView;
    protected CompositeSubscription mSubscription;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        onUnsubscribe();
    }

    /**
     * 添加订阅
     *
     * @param observable
     * @param apiCallBack
     */
    protected void addSubscription(Observable observable, ApiCallBack apiCallBack) {
        if (mSubscription == null) {
            mSubscription = new CompositeSubscription();
        }

        mSubscription.add(observable.subscribe(apiCallBack));
    }

    //RXjava取消注册，以避免内存泄露
    protected void onUnsubscribe() {
        if (mSubscription != null && mSubscription.hasSubscriptions()) {
            mSubscription.unsubscribe();
        }
    }
}
