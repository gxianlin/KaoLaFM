package com.ilynn.kaolafm.ui.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.BroadCastBean;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.activity.FiltrateActivity;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.BroadcastPresenter;
import com.ilynn.kaolafm.ui.view.BroadcastView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

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


    @InjectView(R.id.tabLayout)
    TabLayout mTabLayout;
    @InjectView(R.id.checkbox)
    CheckBox mCheckbox;
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
        mRefresh.setOnRefreshListener(this);
        //设置tablayout的点击监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //每次点击标题会回调此方法
                //初始化完成后默认会调用一次
                LogUtils.e("onTabSelected: " + tab.getPosition());

                //如果点击的是第四项
                if (tab.getPosition() == 3){
                    //让tablayout选中第一项
                    mTabLayout.getTabAt(0).select();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
        //取出电台数据
        BroadCastBean.Menu menu = menus.get(0);

        List<BroadCastBean.Menu.RadioType> dataList = menu.getDataList();
        int size = dataList.size();
        //根据请求的结果个数,设置tablayout的宽度
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mTabLayout.getLayoutParams();
        params.weight = size;
        mTabLayout.setLayoutParams(params);

        //添加标题
        for (int i = 0, j = dataList.size(); i < j; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(tab_icon(dataList.get(i).getName())));
        }
    }

    @Override
    public void onSuccessHot(List<DataListBean<List<Special>>> specials) {
        LogUtils.i(specials);
    }

    @Override
    public void onSuccessRadioHost(List<DataListBean<List<RadioHost>>> radioList) {
        LogUtils.i(radioList);
    }


    @OnClick(R.id.checkbox)
    public void onViewClicked() {
        //由于checkbox每次点击会反选,此处设置不选中(根据需要更改逻辑)
        mCheckbox.setChecked(false);

        //跳转到筛选页面
        startActivityForResult(new Intent(mContext, FiltrateActivity.class), 1000);
    }

    @Override
    public void onRefresh() {
        //请求页面数据
        mPresenter.loadData(mParams, false);
    }

    /**
     * tablayout的tab
     *
     * @param name 名称
     * @return
     */
    private View tab_icon(String name) {
        View newtab = LayoutInflater.from(mContext).inflate(R.layout.tab_icon_view, null);
        TextView tv = (TextView) newtab.findViewById(R.id.tabtext);
        tv.setText(name);
        tabs.add(newtab);
        return newtab;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 1001 && data != null) {
            int index = data.getIntExtra("index", -1);
            if (index > -1) {
                mCheckbox.setChecked(true);
                LogUtils.e(TAG, "Fragment requestCode = " + requestCode + ",resultCode = " + resultCode);
                showToast("Fragment 接收到返回值:" + index);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
