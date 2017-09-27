package com.ilynn.kaolafm.cache;

import android.text.TextUtils;
import android.util.LruCache;

import com.google.gson.Gson;
import com.ilynn.base.util.LogUtils;

import java.io.UnsupportedEncodingException;

import rx.Observable;
import rx.Subscriber;

/**
 * 描述：2级 内存缓存
 * 采用LruCache缓存数据
 * 作者：gong.xl
 * 创建日期：2017/9/27 下午4:54
 * 修改日期: 2017/9/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class MemoryCache implements IJsonCache {
    private static String TAG = "cache";
    private LruCache<String, String> mCache;

    public MemoryCache() {
        //获取系统分配给每个应用程序的最大内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();

        //给LruCache分配1/8
        int mCacheSize = maxMemory / 8;

        //初始化LruCache
        mCache = new LruCache<String, String>(mCacheSize) {
            @Override
            protected int sizeOf(String key, String value) {
                try {
                    return value.getBytes("UTF-8").length;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return value.getBytes().length;
                }
            }
        };
    }

    @Override
    public <T extends BaseCache> Observable<T> get(final String key, final Class<T> cls) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                LogUtils.i(TAG, "从内存读取缓存数据,key = " + key);

                //通过key获取缓存数据
                String result = mCache.get(key);

                if (subscriber.isUnsubscribed()) {
                    return;
                }

                if (TextUtils.isEmpty(result)) {
                    //读取不到缓存时发送空数据
                    subscriber.onNext(null);
                } else {
                    //使用Gson解析数据
                    T data = new Gson().fromJson(result, cls);

                    //发送数据
                    subscriber.onNext(data);
                }

                subscriber.onCompleted();
            }
        });
    }

    @Override
    public <T extends BaseCache> void put(String key, T data) {
        if (data != null) {
            LogUtils.i(TAG, "缓存数据到内存,key = " + key);
            mCache.put(key, data.toString());
        }
    }
}
