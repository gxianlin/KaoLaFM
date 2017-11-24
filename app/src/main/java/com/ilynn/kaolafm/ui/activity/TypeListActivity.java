package com.ilynn.kaolafm.ui.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.TextView;

import com.ilynn.base.util.ToastUtil;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.TypeTabs;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.base.BaseMVPActivity;
import com.ilynn.kaolafm.ui.custom.HorizontalTabView;
import com.ilynn.kaolafm.ui.presenter.TypeTabsPresenter;
import com.ilynn.kaolafm.ui.view.TypeTabsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class TypeListActivity extends BaseMVPActivity<TypeTabsView, TypeTabsPresenter> implements TypeTabsView {

    @InjectView(R.id.title)
    TextView mTitle;
    @InjectView(R.id.viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.tabs)
    HorizontalTabView mTabsView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_typelist;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra(Constants.TITLE);
        mTitle.setText(title);
        //接收所有标题
        String fid = intent.getStringExtra(Constants.FID);
        //判断参数是否错误
        if (TextUtils.isEmpty(fid)) {
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
    }

    @Override
    public void setListener() {

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
        List<String> tabNames = new ArrayList<>();
        for (TypeTabs.DataListBean bean : dataList) {
            tabNames.add(bean.getCategoryName());
        }
        mTabsView.setTabs(tabNames);
    }
}
