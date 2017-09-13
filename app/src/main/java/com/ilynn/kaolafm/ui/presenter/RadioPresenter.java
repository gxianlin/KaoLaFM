package com.ilynn.kaolafm.ui.presenter;

import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.bean.RadioBean;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.RadioView;

import rx.Observable;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/13 0013 21:38
 * 修改日期: 2017/9/13 0013
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RadioPresenter extends CallBackPresenter<RadioView, RadioBean> {
    @Override
    protected Observable<RadioBean> getData() {
        return ApiManager.getInstance().getRadio();
    }

    @Override
    protected void setResult(RadioBean data) {
        mView.onSuccess(data);
    }
}
