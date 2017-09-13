package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.RecommendView;

import rx.Observable;

/**
 * 描述：推荐页面 presenter
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午1:51
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class RecommendPresenter extends CallBackPresenter<RecommendView,Recommend> {
    @Override
    protected Observable<Recommend> getData() {
        return ApiManager.getInstance().getRecommend();
    }

    @Override
    protected void setResult(Recommend data) {
        mView.onSuccess(data);
    }
}
