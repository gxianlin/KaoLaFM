package com.ilynn.kaolafm.ui.fragment;

import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.ilynn.base.BaseFragment;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.adapter.MainPageAdapter;

import butterknife.InjectView;

/**
 * 描述：发现-推荐页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class TypeFragment extends BaseFragment {

    @InjectView(R.id.btn_group)
    RadioGroup mBtnGroup;
    @InjectView(R.id.viewpager)
    ViewPager mViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_type;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

        mBtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.btn_hot) {
                    mViewPager.setCurrentItem(0);
                } else {
                    mViewPager.setCurrentItem(1);
                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mBtnGroup.check(R.id.btn_hot);
                } else {
                    mBtnGroup.check(R.id.btn_other);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initData() {
        MainPageAdapter adapter = new MainPageAdapter(getChildFragmentManager());
        adapter.addFragment(new TypeHotFragment());
        adapter.addFragment(new TypeOtherFragment());
        mViewPager.setAdapter(adapter);
    }

}
