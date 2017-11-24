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
     * 请求网络数据
     *
     * @return
     */
    protected abstract Observable<M> getData(RequestParams params);

    /**
     * 设置数据请求成功回调
     *
     * @param data 数据
     */
    protected abstract void setResult(M data);

    @Override
    public void loadData(final RequestParams params, boolean isNeedCache) {

        //获取数据,采用先内存,后磁盘,最后网络方式
        Observable<M> mObservable = CacheManager.getInstance().loadData(params.toString(), clazz, isNeedCache, new
                NetCache<M>() {
                    @Override
                    public Observable<M> get() {

                        //如果内存和磁盘无缓存数据,或者强制取网络数据时调用此方法
                        return getData(params);
                    }
                });

        //回调处理,因各页面回调仅onSuccess不同,将其抽象
        ApiCallBack<M> apiCallBack = new ApiCallBack<M>() {
            @Override
            public void onStarted() {
                mView.showProgress();
            }

            @Override
            public void onSuccess(M data) {

                //具体数据处理逻辑到具体presenter中处理
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
        };

        //添加统一订阅和回调
        addSubscription(mObservable, apiCallBack);
    }
}
