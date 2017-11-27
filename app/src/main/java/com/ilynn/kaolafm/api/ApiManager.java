package com.ilynn.kaolafm.api;

import android.content.Context;

import com.ilynn.kaolafm.KaoLaApplication;
import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.bean.BroadCastBean;
import com.ilynn.kaolafm.bean.RadioBean;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.bean.TypeList;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.bean.TypeTabs;
import com.ilynn.kaolafm.config.Url;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 描述：请求管理类
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
                .baseUrl(Url.BASE_URL)                              //设置访问环境
                .client(OkHttpClientManager.getClinet(mContext))    //设置OKhttpclient
                .addConverterFactory(GsonConverterFactory.create()) //设置Gson解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())   //设置Rajava适配器
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
     * 请求欢迎页面广告数据
     *
     * @return
     */
    public Observable<Banner> getBanner() {
        return apiService.getBanner().compose(RxResultHelper.<Banner>result());
    }

    /**
     * 请求首页 推荐数据
     *
     * @return
     */
    public Observable<Recommend> getRecommend() {
        return apiService.getRecommend().compose(RxResultHelper.<Recommend>result());
    }

    /**
     * 请求首页 推荐数据
     *
     * @return
     */
    public Observable<TypeMenu> getHotType() {
        return apiService.getHotType().compose(RxResultHelper.<TypeMenu>result());
    }

    /**
     * 请求首页 推荐数据
     *
     * @return
     */
    public Observable<TypeMenu> getOtherType() {
        return apiService.getOtherType().compose(RxResultHelper.<TypeMenu>result());
    }

    /**
     * 请求首页 广播数据
     *
     * @return
     */
    public Observable<BroadCastBean> getBroadcast() {
        return apiService.getBroadcast().compose(RxResultHelper.<BroadCastBean>result());
    }

    /**
     * 请求首页 主播数据
     *
     * @return
     */
    public Observable<RadioBean> getRadio() {
        return apiService.getRadio().compose(RxResultHelper.<RadioBean>result());
    }


    /**
     * 请求分类列表tabs
     *
     * @param fid id
     * @return
     */
    public Observable<TypeTabs> getTypeTabs(String fid) {
        return apiService.getTypeTabs(fid).compose(RxResultHelper.<TypeTabs>result());
    }

    /**
     * 请求分类列表tabs
     *
     * @param cid     id
     * @param pagenum 页码
     * @return
     */
    public Observable<TypeList> getTypeList(int cid, int pagenum) {
        return apiService.getTypeList(cid, pagenum).compose(RxResultHelper.<TypeList>result());
    }

    public Call<ResponseBody> getBody() {
        return apiService.getBody();
    }
}
