package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.TypeRecommendView;

import rx.Observable;

/**
 * Created by Administrator on 2017/12/4.
 */

public class TypeRecommendPresenter extends CallBackPresenter<TypeRecommendView,Recommend> {
    @Override
    protected Observable<Recommend> getData(RequestParams params) {
        //取出id
        int pageId = params.get(Constants.PAGE_ID);
        return ApiManager.getInstance().getRecommend(pageId);
    }

    @Override
    protected void setResult(Recommend data) {
        mView.onRecommendSuccess(data);
    }
}
