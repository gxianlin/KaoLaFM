package com.ilynn.kaolafm.okhttp;

import com.google.gson.internal.$Gson$Types;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午2:53
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class BaseCallBack<T> {
    public Type mType;

    static Type getType(Class<?> subclass){
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class){
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
    }

    public BaseCallBack(){
        mType = getType(this.getClass());
    }

    void onSuccess(T t){};
    void onError(int code){};
    void onFailure(Call call, IOException e){};
}
