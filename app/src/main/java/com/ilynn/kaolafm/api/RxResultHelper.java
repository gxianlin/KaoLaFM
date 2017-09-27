package com.ilynn.kaolafm.api;

import com.ilynn.kaolafm.bean.BaseResult;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Rxjava辅助类
 * 用于线程切换，结果转发
 *
 * @author gong.xl
 * @version 1.0.0
 * @date 2017/4/7  14:29
 * @copyright wonhigh.cn
 */
public class RxResultHelper {
    private static final String TAG = "RxResultHelper";


    private static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(new ApiException("", e.getMessage()));
                }
            }
        });
    }

    public static <T> Observable.Transformer<BaseResult<T>, T> result() {
        return new Observable.Transformer<BaseResult<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseResult<T>> baseResponseObservable) {

                return baseResponseObservable.flatMap(
                        new Func1<BaseResult<T>, Observable<T>>() {
                            @Override
                            public Observable<T> call(BaseResult<T> response) {
                                //请求成功后，根据返回码转发
                                switch (response.getCode()) {
                                    //正常数据
                                    case ApiException.SUCCESS:
                                        return createData(response.getResult());
                                    //其他异常数据可在此处理转发
                                    default:
                                        return Observable.error(new ApiException(response.getCode(), response
                                                .getMessage()));
                                }
                            }
                        }
                ).unsubscribeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
