package com.ilynn.kaolafm.api;

import com.google.gson.internal.$Gson$Types;
import com.ilynn.base.util.Logger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import rx.Subscriber;


 /**
 * 描述：处理网络数据处理完成后的回调响应
 *
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

        if (mType instanceof Class) {
            clazz = (Class<M>) mType;
            Logger.i(TAG, "class = " + clazz.getSimpleName() + " + " + clazz.getName() + " + " + clazz
                    .getCanonicalName());
        } else if (mType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) mType;
            Type[] actualTypeArguments = type.getActualTypeArguments();
            clazz = (Class<M>) actualTypeArguments[0];
            Logger.i(TAG, "ArrayList<Class> = " + clazz.getSimpleName() + " + " + clazz.getName() +
                    " + " + clazz
                    .getCanonicalName());
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
    }

    @Override
    public void onNext(M m) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }


}
