package com.ilynn.kaolafm.api;

import android.content.Context;

import com.ilynn.kaolafm.KaoLaApplication;
import com.ilynn.kaolafm.bean.Banner;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 22:48
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class ApiManager {
    private static final String TAG = "ApiManager";
    private Retrofit mRetrofit;
    private ApiService apiService;
    private static Context mContext;
    private static ApiManager apiManager;

    //初始化Retrofit
    private ApiManager(Context context) {
        mContext = context;

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)        //设置访问环境
                .client(OkHttpClientManager.getClinet(mContext))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        if (apiService == null) {
            apiService = mRetrofit.create(ApiService.class);
        }
    }

    /**
     * 获取单例ApiManager对象
     *
     * @return
     */
    public static ApiManager getInstance() {
        if (apiManager == null) {
            synchronized (ApiManager.class) {
                if (apiManager == null)
                    apiManager = new ApiManager(KaoLaApplication.getContext());
            }
        }
        return apiManager;
    }

    /**
     * 清除ApiManager对象
     */
    public static void cencleApimanager() {
        if (apiManager != null) {
            apiManager = null;
        }
    }






    /**
     * 请求销售总览页面数据
     *
     * @param map 请求参数
     * @return
     */
    public Observable<Banner> getBanner() {
        return apiService.getBanner().compose(RxResultHelper.<Banner>result());
    }
}
