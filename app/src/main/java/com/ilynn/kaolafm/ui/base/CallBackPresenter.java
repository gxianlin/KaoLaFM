package com.ilynn.kaolafm.ui.base;

import com.ilynn.kaolafm.api.ApiCallBack;
import com.ilynn.kaolafm.bean.BaseResult;

import rx.Observable;

/**
 * 描述：MVP presenter
 *      进一步封装,使得使用时更方便更简洁
 *
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午1:39
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class CallBackPresenter<V extends IView, M extends BaseResult> extends BasePresenter<V> {
    /**
     * 请求数据
     * @return
     */
    protected abstract Observable<M> getData();

    /**
     * 设置数据回调
     * @param data 数据
     */
    protected abstract void setResult(M data);

    @Override
    public void loadData() {
        addSubscription(getData(), new ApiCallBack<M>() {
            @Override
            public void onStarted() {
                mView.showProgress();
            }

            @Override
            public void onSuccess(M data) {
                setResult(data);
            }

            @Override
            public void onFailure(int code, String message) {
                mView.onError(code, message);
            }

            @Override
            public void onFinished() {
                mView.hideProgress();
            }
        });
    }
}
