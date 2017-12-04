package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.TypeId;
import com.ilynn.kaolafm.bean.TypePageConfig;
import com.ilynn.kaolafm.bean.TypeTabs;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.TypeConfigView;

import rx.Observable;
import rx.functions.Func2;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/24 下午2:12
 * 修改日期: 2017/11/24
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class TypeTabsPresenter extends CallBackPresenter<TypeConfigView, TypePageConfig> {
    @Override
    protected Observable<TypePageConfig> getData(RequestParams params) {
        int fid = params.get(Constants.FID);

        Observable<TypeTabs> typeTabs = ApiManager.getInstance().getTypeTabs(fid);
        Observable<TypeId> typeIds = ApiManager.getInstance().getTypeIds(fid);


        return Observable.zip(typeTabs, typeIds, new Func2<TypeTabs, TypeId, TypePageConfig>() {
            @Override
            public TypePageConfig call(TypeTabs typeTabs, TypeId typeId) {
                return new TypePageConfig(typeTabs, typeId);
            }
        });
    }

    @Override
    protected void setResult(TypePageConfig data) {

        mView.onIdSuccess(data.getTypeId());

        mView.onTabsSuccess(data.getTypeTabs());
    }
}
