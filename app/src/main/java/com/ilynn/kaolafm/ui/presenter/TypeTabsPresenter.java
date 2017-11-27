package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.TypeTabs;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.TypeTabsView;

import rx.Observable;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/24 下午2:12
 * 修改日期: 2017/11/24
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class TypeTabsPresenter extends CallBackPresenter<TypeTabsView, TypeTabs> {
    @Override
    protected Observable<TypeTabs> getData(RequestParams params) {
        String fid = params.get(Constants.FID);
        return ApiManager.getInstance().getTypeTabs(fid);
    }

    @Override
    protected void setResult(TypeTabs data) {
        mView.onTabsSuccess(data);
    }
}
