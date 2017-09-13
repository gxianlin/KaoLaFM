package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.bean.BroadCastBean;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.BroadcastView;

import rx.Observable;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午4:54
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BroadcastPresenter extends CallBackPresenter<BroadcastView,BroadCastBean> {
    @Override
    protected Observable<BroadCastBean> getData() {
        return ApiManager.getInstance().getBroadcast();
    }

    @Override
    protected void setResult(BroadCastBean data) {
        mView.onSuccess(data);
    }
}
