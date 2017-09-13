package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.TypeView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 描述：分类页面 presenter
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午2:38
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class TypePresenter extends CallBackPresenter<TypeView, TypeMenu> {

    @Override
    protected Observable<TypeMenu> getData() {

        //请求热门分类数据
        Observable<TypeMenu> hotType = ApiManager.getInstance().getHotType();

        //请求其他分类数据
        Observable<TypeMenu> otherType = ApiManager.getInstance().getOtherType();

        //合并数据
        return Observable.merge(hotType, otherType).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread());
    }

    @Override
    protected void setResult(TypeMenu data) {
        if (data.getName().equals("热门分类")) {
            mView.hotTypeSuccess(data);
        } else {
            mView.otherTypeSuccess(data);
        }
    }
}
