package com.ilynn.kaolafm.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.adapter.RadioAdapter;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.custom.RecyclerViewDecoration;
import com.ilynn.kaolafm.ui.presenter.RadioPresenter;
import com.ilynn.kaolafm.ui.view.RadioView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 描述：发现-主播页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RadioFragment extends BaseMVPFragment<RadioView, RadioPresenter> implements RadioView,
        SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @InjectView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    private RadioAdapter mRadioAdapter;
    List<DataListBean<List<Special>>> mRadioList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_radio;
    }

    @Override
    public void initViews() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerview.addItemDecoration(new RecyclerViewDecoration());
    }

    @Override
    public void setListener() {
        mRefresh.setOnRefreshListener(this);
    }

    @Override
    public void initData() {
        mPresenter.loadData(mParams,true);
        //        mRadioList = new ArrayList<>();
        //        mRadioAdapter = new RadioAdapter(mRadioList);
        //        mRecyclerview.setAdapter(mRadioAdapter);
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
    public void onSuccessBanner(List<Special> bannerList) {
        //        mRadioAdapter.setBannerList(bannerList);
        DataListBean<List<Special>> bean = new DataListBean<>();
        bean.setDataList(bannerList);

        mRadioList = new ArrayList<>();
        mRadioList.add(bean);
        mRadioAdapter = new RadioAdapter(mRadioList);
        mRecyclerview.setAdapter(mRadioAdapter);


    }

    @Override
    public void onSuccessMessage(List<Special> textList) {
        //        mRadioAdapter.setTextList(textList);
    }

    @Override
    public void onSuccessRadio(List<DataListBean<List<RadioHost>>> radioList) {
        mRadioList.clear();
        mRadioAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        mPresenter.loadData(mParams,false);
    }
}
