package com.ilynn.kaolafm.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;

import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.BroadCastBean;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.BroadcastPresenter;
import com.ilynn.kaolafm.ui.view.BroadcastView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 描述：发现-广播页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class BroadcastFragment extends BaseMVPFragment<BroadcastView, BroadcastPresenter> implements BroadcastView,
        SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.refresh)
    SwipeRefreshLayout mRefresh;


    ArrayList<View> tabs = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_broadcast;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {
    }

    @Override
    public void initData() {
        mPresenter.loadData(mParams, true);
    }

    @Override
    public void showProgress() {
        mRefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mRefresh.setRefreshing(false);
    }

    @Override
    public void onError(int code, String message) {

    }

    @Override
    public void onSuccessMenu(List<BroadCastBean.Menu> menus) {

    }

    @Override
    public void onSuccessHot(List<DataListBean<List<Special>>> specials) {
        LogUtils.i(specials);
    }

    @Override
    public void onSuccessRadioHost(List<DataListBean<List<RadioHost>>> radioList) {
        LogUtils.i(radioList);
    }

    @Override
    public void onRefresh() {
        //请求页面数据
        mPresenter.loadData(mParams, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("tag", "onResume");
    }
}
