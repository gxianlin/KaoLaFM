package com.ilynn.kaolafm.ui.base;

import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.api.ApiCallBack;

import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/**
 * 描述：基础presenter
 * 添加统一的订阅关系
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午4:50
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class BasePresenter<V extends IView> implements IPresenter<V>, BaseModel {
    protected V mView;
    protected CompositeSubscription mSubscription;
    private String mViewName;

    @Override
    public void attachView(V view) {
        mView = view;
        mViewName = mView.getClass().getSimpleName();
    }

    @Override
    public void detachView() {

        mView = null;
        onUnsubscribe();
    }

    /**
     * 添加订阅
     *
     * @param observable  数据
     * @param apiCallBack 结果回调
     */
    protected void addSubscription(Observable observable, ApiCallBack apiCallBack) {
        if (mSubscription == null) {
            mSubscription = new CompositeSubscription();
        }

        mSubscription.add(observable.subscribe(apiCallBack));
        LogUtils.d("添加订阅:" + mViewName);
    }

    //RXjava取消注册，以避免内存泄露
    protected void onUnsubscribe() {
        if (mSubscription != null && mSubscription.hasSubscriptions()) {
            mSubscription.unsubscribe();
            LogUtils.d("取消注册:" + mViewName);
        }
    }
}
