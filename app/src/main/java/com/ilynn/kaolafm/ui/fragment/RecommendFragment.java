package com.ilynn.kaolafm.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.config.LayoutType;
import com.ilynn.kaolafm.ui.adapter.RecommendAdapter;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.custom.RecyclerViewDecoration;
import com.ilynn.kaolafm.ui.presenter.RecommendPresenter;
import com.ilynn.kaolafm.ui.view.RecommendView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 描述：发现-推荐页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhih.cn
 */
public class RecommendFragment extends BaseMVPFragment<RecommendView, RecommendPresenter> implements RecommendView,
        SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @InjectView(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    private RecommendAdapter mAdapter;

    List<DataListBean<List<Special>>> mDataList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
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
        mDataList = new ArrayList<>();
        mAdapter = new RecommendAdapter(mDataList);
        mRecyclerview.setAdapter(mAdapter);
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
    public void onSuccess(Recommend recommend) {
        List<DataListBean<List<Special>>> dataList = recommend.getDataList();
        Log.e(TAG,recommend.toString());
        mDataList.clear();
        //筛选数据
        for (int i = dataList.size() - 1; i >= 0; i--) {
            int type = dataList.get(i).getItemType();
            if (type != LayoutType.BANNER && type != LayoutType.ENTRY && type != LayoutType.SECTION_MENU &&
                    type != LayoutType.SECTION_SQUARE && type != LayoutType.SECTION_VERTICAL) {
                dataList.remove(i);
            }
        }
        mDataList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        //请求数据
        mPresenter.loadData(mParams,true);
    }
}
