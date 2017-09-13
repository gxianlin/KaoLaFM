package com.ilynn.kaolafm.ui.fragment;

import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.RadioBean;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.RadioPresenter;
import com.ilynn.kaolafm.ui.view.RadioView;

/**
 * 描述：发现-主播页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RadioFragment extends BaseMVPFragment<RadioView, RadioPresenter> implements RadioView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_offline;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        mPresenter.loadData();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(int code, String message) {

    }

    @Override
    public void onSuccess(RadioBean radioBean) {
        LogUtils.e(TAG, "onSuccess");
    }
}
