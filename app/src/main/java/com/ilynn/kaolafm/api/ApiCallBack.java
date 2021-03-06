package com.ilynn.kaolafm.api;

import com.google.gson.internal.$Gson$Types;
import com.ilynn.base.util.LogUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import rx.Subscriber;


/**
 * 描述：处理网络数据处理完成后的回调响应
 * <p>
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午5:05
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public abstract class ApiCallBack<M> extends Subscriber<M> {
    private String TAG = "ApiCallBack";

    public Type mType;
    private Class<M> clazz;

    static Type getSuperClassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
    }

    public ApiCallBack() {
        mType = getSuperClassTypeParameter(this.getClass());

        //泛型M类型为Bean (class)
        if (mType instanceof Class) {
            clazz = (Class<M>) mType;
            LogUtils.i(TAG, "class = " + clazz.getSimpleName() + " + " + clazz.getName() + " + " + clazz
                    .getCanonicalName());
        }
        //泛型M类型为 Array<Bean>
        else if (mType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) mType;
            Type[] actualTypeArguments = type.getActualTypeArguments();
            clazz = (Class<M>) actualTypeArguments[0];
        }
    }


    /**
     * 请求开始
     */
    public abstract void onStarted();


    /**
     * 请求成功回调
     *
     * @param data
     */
    public abstract void onSuccess(M data);

    /**
     * 请求失败回调
     *
     * @param code
     * @param message
     */
    public abstract void onFailure(int code, String message);

    /**
     * 请求结束回调
     */
    public abstract void onFinished();


    @Override
    public void onStart() {
        super.onStart();
        onStarted();
    }

    @Override
    public void onNext(M m) {
        //TODO 可在此检测数据是否是正常数据,再进行转发
        onSuccess(m);
    }

    @Override
    public void onCompleted() {
        onFinished();
    }

    @Override
    public void onError(Throwable e) {

        //TODO 区分异常类型
        onFailure(1, e.getMessage());
        onFinished();
    }


}
