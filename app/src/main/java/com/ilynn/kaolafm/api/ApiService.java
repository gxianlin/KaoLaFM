package com.ilynn.kaolafm.api;

import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.bean.BaseBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 22:27
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public interface ApiService {
    String BASE_URL = "http://api.kaolafm.com/api/v4/";

    String MENU_TAB = "4.7.1/navigate/list";

    String BANNER = "splashscreen/list?resolution=800*1280&devicetype=0&channel=A-myapp&version=5.0.2&appid=0&";

    @GET(BANNER)
    Observable<BaseBean<Banner>> getBanner();
}
