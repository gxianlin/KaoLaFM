package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.TypeList;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.TypeListView;

import rx.Observable;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/27 上午10:22
 * 修改日期: 2017/11/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class TypeListPresenter extends CallBackPresenter<TypeListView, TypeList> {
    @Override
    protected Observable<TypeList> getData(RequestParams params) {
        //取出参数
        int cid = params.get(Constants.CID);
        int pagenum = params.get(Constants.PAGENUM);
        return ApiManager.getInstance().getTypeList(cid, pagenum);
    }

    @Override
    protected void setResult(TypeList data) {
        mView.onListSuccess(data);
    }
}
