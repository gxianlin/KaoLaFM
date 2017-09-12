package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiCallBack;
import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.ui.base.BasePresenter;
import com.ilynn.kaolafm.ui.model.BannerModel;
import com.ilynn.kaolafm.ui.view.BannerView;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 22:45
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class BannerPresenter extends BasePresenter<BannerView> implements BannerModel {

    @Override
    public void loadBanner() {
        addSubscription(ApiManager.getInstance().getBanner(), new ApiCallBack<Banner>() {
            @Override
            public void onStarted() {
                mView.showProgress();
            }

            @Override
            public void onSuccess(Banner data) {
                mView.success(data);
            }

            @Override
            public void onFailure(int code, String message) {
                mView.showFail(code, message);
            }

            @Override
            public void onFinished() {
                mView.hideProgress();
            }
        });
    }
}
