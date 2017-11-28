package com.ilynn.kaolafm.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.TypeList;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.adapter.TypeListAdapter;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.custom.CustomRecyclerView;
import com.ilynn.kaolafm.ui.presenter.TypeListPresenter;
import com.ilynn.kaolafm.ui.view.TypeListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 描述：其他分类详情列表页面
 * 作者：gong.xl
 * 创建日期：2017/11/27 上午10:14
 * 修改日期: 2017/11/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class TypeListFragment extends BaseMVPFragment<TypeListView, TypeListPresenter> implements TypeListView {

    @InjectView(R.id.recyclerview)
    CustomRecyclerView mRecyclerview;
    private int mPageNum = 1;
    private List<TypeList.DataListBean> mDataList;
    private TypeListAdapter mTypeListAdapter;
    private boolean mHavaNext;
    private boolean isRefresh;

    public static TypeListFragment newInstance(int cid) {
        TypeListFragment fragment = new TypeListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.CID, cid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_type_list;
    }

    @Override
    public void initViews() {
        mDataList = new ArrayList<>();
        mRecyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mTypeListAdapter = new TypeListAdapter(mContext);
        mTypeListAdapter.setDataList(mDataList);
        mRecyclerview.setAdapter(mTypeListAdapter);
        mRecyclerview.setMode(CustomRecyclerView.REFRESH_MODE_BOTH);

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        mParams.put(Constants.CID, bundle.getInt(Constants.CID));
        mParams.put(Constants.PAGENUM, mPageNum);
        mPresenter.loadData(mParams, true);
    }

    @Override
    public void setListener() {
        mRecyclerview.setOnRVListener(new CustomRecyclerView.OnRVListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                mPageNum = 1;
                mParams.put(Constants.PAGENUM, mPageNum);
                mPresenter.loadData(mParams, false);
            }

            @Override
            public void onLoadMore() {
                isRefresh = false;
                if (mHavaNext) {
                    mParams.put(Constants.PAGENUM, mPageNum);
                    mPresenter.loadData(mParams, true);
                }else {
                    //没有更多了
                }
            }
        });
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
    public void onListSuccess(TypeList list) {
        //如果是刷新状态,先清空数据
        if (isRefresh){
            mTypeListAdapter.clearData();
        }

        mRecyclerview.onComplete();
        mPageNum = list.getNextPage();

        if (list.getHaveNext() == 0) {
            mHavaNext = false;
        } else {
            mHavaNext = true;
        }
        mTypeListAdapter.addDataList(list.getDataList());
    }
}
