package com.ilynn.kaolafm.api;

import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.bean.BaseBean;
import com.ilynn.kaolafm.bean.BroadCastBean;
import com.ilynn.kaolafm.bean.RadioBean;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.bean.TypeMenu;

import retrofit2.http.GET;
import rx.Observable;

import static com.ilynn.kaolafm.config.Url.BANNER;
import static com.ilynn.kaolafm.config.Url.BROADCAST;
import static com.ilynn.kaolafm.config.Url.HOT_TYPE;
import static com.ilynn.kaolafm.config.Url.OTHER_TYPE;
import static com.ilynn.kaolafm.config.Url.RADIO;
import static com.ilynn.kaolafm.config.Url.RECOMMEND;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 22:27
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public interface ApiService {

    @GET(BANNER)
    Observable<BaseBean<Banner>> getBanner();

    @GET(RECOMMEND)
    Observable<BaseBean<Recommend>> getRecommend();

    @GET(HOT_TYPE)
    Observable<BaseBean<TypeMenu>> getHotType();

    @GET(OTHER_TYPE)
    Observable<BaseBean<TypeMenu>> getOtherType();

    @GET(BROADCAST)
    Observable<BaseBean<BroadCastBean>> getBroadcast();

    @GET(RADIO)
    Observable<BaseBean<RadioBean>> getRadio();
}
