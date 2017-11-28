package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.bean.MineBean;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.MineView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/28 下午5:04
 * 修改日期: 2017/11/28
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class MinePresenter extends CallBackPresenter<MineView, MineBean> {
    @Override
    protected Observable<MineBean> getData(RequestParams params) {

        //请求分类热门菜单
        Observable<TypeMenu> hotType = ApiManager.getInstance().getHotType();

        //请求广告页数据
        Observable<Banner> banner = ApiManager.getInstance().getBanner();

        return Observable.zip(hotType, banner, new Func2<TypeMenu, Banner, MineBean>() {
            @Override
            public MineBean call(TypeMenu menu, Banner banner) {
                return new MineBean(banner, menu);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    protected void setResult(MineBean data) {
        mView.onBannerSuccess(data.getBanner());

        mView.onMenuSuccess(data.getMenu());
    }
}
