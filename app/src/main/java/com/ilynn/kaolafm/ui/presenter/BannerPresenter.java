package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.BannerView;

import rx.Observable;

/**
 * 描述：欢迎页广告 presenter
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 22:45
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class BannerPresenter extends CallBackPresenter<BannerView, Banner> {

    @Override
    public Observable getData(RequestParams params) {
        return ApiManager.getInstance().getBanner();
    }

    @Override
    public void setResult(Banner data) {
        mView.onSuccess(data);
    }

}
