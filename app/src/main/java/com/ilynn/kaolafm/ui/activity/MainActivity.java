package com.ilynn.kaolafm.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ilynn.base.BaseActivity;
import com.ilynn.base.util.DensityUtil;
import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.adapter.MainPageAdapter;
import com.ilynn.kaolafm.ui.custom.PlayView;
import com.ilynn.kaolafm.ui.fragment.DiscoverFragment;
import com.ilynn.kaolafm.ui.fragment.HomeFragment;
import com.ilynn.kaolafm.ui.fragment.MineFragment;
import com.ilynn.kaolafm.ui.fragment.OfflineFragment;

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


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(tab_icon("首页", R.drawable.main_btn_discover)));
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(tab_icon("发现", R.drawable.main_btn_manage)));
        //添加中间一个空按钮用于占位
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(null));
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(tab_icon("离线", R.drawable.main_btn_offline)));
        mMainTablayout.addTab(mMainTablayout.newTab().setCustomView(tab_icon("我的", R.drawable.main_btn_mine)));

        //设置空按钮不可点击
        LinearLayout child = (LinearLayout) mMainTablayout.getChildAt(0);
        child.getChildAt(2).setClickable(false);
        //        initButton();
    }


    @Override
    public void initData() {
        setCustomViewPager();


        //接收携带参数,之前是传递的2
        int tag = getIntent().getIntExtra("tag", -1);
        //调用此方法需在viewpager初始化完毕之后

        if(tag != -1) {
            //让viewpager选中第三个页面
            mMainViewpager.setCurrentItem(tag);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LogUtils.e(TAG, "Activity requestCode = " + requestCode + ",resultCode = " + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setListener() {
        mMainTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position > 2)
                    position--;
                mMainViewpager.setCurrentItem(position);
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
        adapter.addFragment(new DiscoverFragment());
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


    private WindowManager wm = null;
    private WindowManager.LayoutParams wmParams = null;
    private PlayView leftbtn = null;


    private void initButton() {
        //获取WindowManager
        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //设置LayoutParams(全局变量）相关参数
        wmParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        //设置悬浮窗口长宽数据
        wmParams.width = DensityUtil.dp2px(55);
        wmParams.height = DensityUtil.dp2px(70);
        createLeftFloatView();
        leftbtn.invalidate();
    }

    /**
     * 创建悬浮按钮
     */
    private void createLeftFloatView() {
        leftbtn = new PlayView(getApplicationContext());
        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.e("点击悬浮按钮");
            }
        });
        //调整悬浮窗口
        wmParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        //显示myFloatView图像
        wm.addView(leftbtn, wmParams);
    }

    @Override
    protected void onDestroy() {

        if (leftbtn != null && wm != null) {
            wm.removeView(leftbtn);
        }
        super.onDestroy();
    }

    public void setCurrent(int index) {
        if (mMainViewpager != null) {
            mMainViewpager.setCurrentItem(index);
        }
    }
}
