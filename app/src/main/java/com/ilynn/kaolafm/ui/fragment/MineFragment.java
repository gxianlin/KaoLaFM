package com.ilynn.kaolafm.ui.fragment;

import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.MinePresenter;
import com.ilynn.kaolafm.ui.view.MineView;

/**
 * 描述：主页面  发现
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class MineFragment extends BaseMVPFragment<MineView, MinePresenter> implements MineView {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        mPresenter.loadData(mParams, false);
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
    public void onMenuSuccess(TypeMenu menu) {
        //请求一数据
        LogUtils.e("onMenuSuccess");
    }

    @Override
    public void onBannerSuccess(Banner banner) {
        //请求二数据
        LogUtils.e("onBannerSuccess");
    }
}
