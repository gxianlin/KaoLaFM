package com.ilynn.kaolafm.ui.fragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.ui.adapter.CommonTabPagerAdapter;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.TypePresenter;
import com.ilynn.kaolafm.ui.view.TypeView;

import java.util.Arrays;

import butterknife.InjectView;

import static com.ilynn.kaolafm.R.id.tabLayout;

/**
 * 描述：发现-推荐页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class TypeFragment extends BaseMVPFragment<TypeView, TypePresenter> implements TypeView, CommonTabPagerAdapter
        .TabPagerListener {

    @InjectView(tabLayout)
    TabLayout mTabLayout;
    @InjectView(R.id.appbar)
    AppBarLayout mAppbar;
    @InjectView(R.id.viewpager_1)
    ViewPager mViewpager1;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_type;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        CommonTabPagerAdapter adapter = new CommonTabPagerAdapter(getChildFragmentManager(), 3, Arrays.asList("美食",
                "电影", "玩乐"), mContext);
        adapter.setListener(this);
        mViewpager1.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewpager1);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
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
    public void hotTypeSuccess(TypeMenu hotType) {
        LogUtils.e(hotType.getName());
    }

    @Override
    public void otherTypeSuccess(TypeMenu otherType) {
        LogUtils.e(otherType.getName());
    }

    @Override
    public Fragment getFragment(int position) {
        return DemoFragment.newInstance(position);
    }
}
