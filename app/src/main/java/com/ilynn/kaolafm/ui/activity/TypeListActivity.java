package com.ilynn.kaolafm.ui.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.ilynn.base.util.ToastUtil;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.TypeId;
import com.ilynn.kaolafm.bean.TypeTabs;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.adapter.MainPageAdapter;
import com.ilynn.kaolafm.ui.base.BaseMVPActivity;
import com.ilynn.kaolafm.ui.custom.HorizontalTabView;
import com.ilynn.kaolafm.ui.fragment.TypeListFragment;
import com.ilynn.kaolafm.ui.fragment.TypeRecommendFragment;
import com.ilynn.kaolafm.ui.presenter.TypeTabsPresenter;
import com.ilynn.kaolafm.ui.view.TypeConfigView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class TypeListActivity extends BaseMVPActivity<TypeConfigView, TypeTabsPresenter> implements TypeConfigView {

    @InjectView(R.id.title)
    TextView mTitle;
    @InjectView(R.id.viewpager)
    ViewPager mViewPager;
    @InjectView(R.id.tabs)
    HorizontalTabView mTabsView;
    private MainPageAdapter mAdapter;
    private List<String> tabNames;


    @Override
    public int getLayoutId() {
        return R.layout.activity_typelist;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        tabNames = new ArrayList<>();

        Intent intent = getIntent();
        String title = intent.getStringExtra(Constants.TITLE);
        mTitle.setText(title);
        //接收所有标题
        int fid = intent.getIntExtra(Constants.FID, -1);
        //判断参数是否错误
        if (fid == -1) {
            ToastUtil.showShort(this, "参数传递错误,即将关闭页面.");
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        }
        mParams.put(Constants.FID, fid);
        mPresenter.loadData(mParams, false);
        //判断是否需要添加精选页面
        mAdapter = new MainPageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void setListener() {
        mTabsView.setViewPager(mViewPager);
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
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
    public void onTabsSuccess(TypeTabs tabs) {
        List<TypeTabs.DataListBean> dataList = tabs.getDataList();

        //根据标题个数添加相应的标题栏和fragment
        for (TypeTabs.DataListBean bean : dataList) {
            tabNames.add(bean.getCategoryName());
            mAdapter.addFragment(TypeListFragment.newInstance(bean.getCategoryId()));
        }
        mTabsView.setTabs(tabNames);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onIdSuccess(TypeId id) {
        //判断是否需要添加精选页面
        int pageId = id.getPageId();
        if (pageId > 0) {
            tabNames.add("精选");
            mAdapter.addFragment(TypeRecommendFragment.newInstance(pageId));
        }
    }
}
