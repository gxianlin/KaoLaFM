package com.ilynn.kaolafm.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.ilynn.base.BaseFragment;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.adapter.MainPageAdapter;

import butterknife.InjectView;

/**
 * 描述：主页面  发现
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class DiscoverFragment extends BaseFragment {

    @InjectView(R.id.tab_layout)
    TabLayout mTabLayout;
    @InjectView(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        MainPageAdapter adapter = new MainPageAdapter(getChildFragmentManager());
        adapter.addFragment(new RecommendFragment());
        adapter.addFragment(new TypeFragment());
        adapter.addFragment(new BroadcastFragment());
        adapter.addFragment(new RadioFragment());
        adapter.setTitles(getResources().getStringArray(R.array.tab_names));
        mViewpager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewpager);
    }
}
