package com.ilynn.kaolafm.ui.base;

import com.ilynn.kaolafm.api.ApiCallBack;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.cache.BaseCache;
import com.ilynn.kaolafm.cache.CacheManager;
import com.ilynn.kaolafm.cache.NetCache;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import rx.Observable;

/**
 * 描述：MVP presenter
 * 进一步封装,使得使用时更方便更简洁
 * <p>
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午1:39
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class CallBackPresenter<V extends IView, M extends BaseCache> extends BasePresenter<V> {
    private Class<M> clazz;

    public CallBackPresenter() {
        //获取数据的泛型类型
        Type type = getClass().getGenericSuperclass();
        Type types = ((ParameterizedType) type).getActualTypeArguments()[1];
        clazz = (Class<M>) types;
    }

    /**
     * 请求数据
     *
     * @return
     */
    protected abstract Observable<M> getData();

    /**
     * 设置数据回调
     *
     * @param data 数据
     */
    protected abstract void setResult(M data);

    @Override
    public void loadData(RequestParams params, boolean isNeedCache) {
        addSubscription(CacheManager.getInstance().loadData(params.toString(), clazz, isNeedCache, new NetCache<M>() {
            @Override
            public Observable<M> get() {
                return getData();
            }
        }), new ApiCallBack<M>() {
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
