package com.ilynn.kaolafm.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilynn.base.BaseActivity;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.adapter.MainPageAdapter;
import com.ilynn.kaolafm.ui.fragment.HomeFragment;
import com.ilynn.kaolafm.ui.fragment.MineFragment;
import com.ilynn.kaolafm.ui.fragment.OfflineFragment;
import com.ilynn.kaolafm.ui.fragment.TypeFragment;

import java.util.ArrayList;

import butterknife.InjectView;

/**
 * 描述：主页面
 * <p>
 * 作者：gong.xl
 * 创建日期：2017/9/10 下午5:05
 * 修改日期: 2017/9/10
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class MainActivity extends BaseActivity {

    @InjectView(R.id.main_viewpager)
    ViewPager mMainViewpager;
    @InjectView(R.id.main_tablayout)
    TabLayout mMainTablayout;

    ArrayList<View> tabs = new ArrayList<>();

    // 定义一个变量，来标识是否退出
//    private static boolean isExit = false;

//    @SuppressLint("HandlerLeak")
//    Handler mHandler = new Handler() {
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            isExit = false;
//        }
//    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(tab_icon("首页", R.drawable.main_btn_discover)));
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(tab_icon("分类", R.drawable.main_btn_manage)));
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(tab_icon("离线", R.drawable.main_btn_offline)));
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(tab_icon("我的", R.drawable.main_btn_mine)));
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public void initData() {
        setCustomViewPager();
    }

    @Override
    public void setListener() {
        mMainTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mMainViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mMainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < tabs.size(); i++) {
                    if (position == i) {
                        tabs.get(i).setSelected(true);
                    } else {
                        tabs.get(i).setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 设置自定义viewpager
     */
    private void setCustomViewPager() {
        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new TypeFragment());
        adapter.addFragment(new OfflineFragment());
        adapter.addFragment(new MineFragment());
        mMainViewpager.setAdapter(adapter);
        mMainViewpager.setCurrentItem(0);
    }

    private View tab_icon(String name, int iconID) {
        View newtab = LayoutInflater.from(this).inflate(R.layout.icon_view, null);
        TextView tv = (TextView) newtab.findViewById(R.id.tabtext);
        tv.setText(name);
        ImageView im = (ImageView) newtab.findViewById(R.id.tabicon);
        im.setImageResource(iconID);
        tabs.add(newtab);
        return newtab;
    }

    @Override
    public void onKeyBack() {
        finish();
    }
}
