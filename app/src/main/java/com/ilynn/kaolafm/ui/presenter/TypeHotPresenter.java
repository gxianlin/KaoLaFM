package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.TypeHotView;

import rx.Observable;

/**
 * 描述：分类页面 presenter
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午2:38
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class TypeHotPresenter extends CallBackPresenter<TypeHotView, TypeMenu> {

    @Override
    protected Observable<TypeMenu> getData(RequestParams params) {

        //请求热门分类数据
        return ApiManager.getInstance().getHotType();
    }

    @Override
    protected void setResult(TypeMenu data) {
        mView.typeHotSuccess(data);
    }
}
