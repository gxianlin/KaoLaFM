package com.ilynn.kaolafm.api;

import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.bean.BaseResult;
import com.ilynn.kaolafm.bean.BroadCastBean;
import com.ilynn.kaolafm.bean.RadioBean;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.bean.TypeId;
import com.ilynn.kaolafm.bean.TypeList;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.bean.TypeTabs;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

import static com.ilynn.kaolafm.config.Url.BANNER;
import static com.ilynn.kaolafm.config.Url.BROADCAST;
import static com.ilynn.kaolafm.config.Url.CHOICENESS;
import static com.ilynn.kaolafm.config.Url.HOT_TYPE;
import static com.ilynn.kaolafm.config.Url.OTHER_TYPE;
import static com.ilynn.kaolafm.config.Url.RADIO;
import static com.ilynn.kaolafm.config.Url.RECOMMEND;
import static com.ilynn.kaolafm.config.Url.TYPE_IDS;
import static com.ilynn.kaolafm.config.Url.TYPE_LIST;
import static com.ilynn.kaolafm.config.Url.TYPE_TABS;

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
    Observable<BaseResult<Banner>> getBanner();

    @GET(CHOICENESS)
    Observable<BaseResult<Recommend>> getRecommend(@Query("pageid") int pageid);

    @GET(HOT_TYPE)
    Observable<BaseResult<TypeMenu>> getHotType();

    @GET(OTHER_TYPE)
    Observable<BaseResult<TypeMenu>> getOtherType();

    @GET(BROADCAST)
    Observable<BaseResult<BroadCastBean>> getBroadcast();

    @GET(RADIO)
    Observable<BaseResult<RadioBean>> getRadio();

    @GET(TYPE_TABS)
    Observable<BaseResult<TypeTabs>> getTypeTabs(@Query("fid") int fid);

    @GET(TYPE_IDS)
    Observable<BaseResult<TypeId>> getTypeIds(@Query("id") int fid);

    @GET(TYPE_LIST)
    Observable<BaseResult<TypeList>> getTypeList(@Query("cid") int cid, @Query("pagenum") int pagenum);
}
