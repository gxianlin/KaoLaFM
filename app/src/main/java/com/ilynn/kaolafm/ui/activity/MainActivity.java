package com.ilynn.kaolafm.ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ilynn.base.BaseActivity;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.adapter.MainPageAdapter;
import com.ilynn.kaolafm.ui.fragment.DiscoverFragment;
import com.ilynn.kaolafm.ui.fragment.MineFragment;
import com.ilynn.kaolafm.ui.fragment.OfflineFragment;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.OnClick;

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

    @InjectView(R.id.bar_music)
    ImageView mBarMusic;
    @InjectView(R.id.bar_offline)
    ImageView mBarNet;
    @InjectView(R.id.bar_mine)
    ImageView mBarFriends;
    @InjectView(R.id.bar_search)
    ImageView mBarSearch;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.bottom_container)
    FrameLayout mBottomContainer;
    @InjectView(R.id.main_viewpager)
    ViewPager mMainViewpager;

    private long time;

    private ArrayList<ImageView> tabs = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        setCustomViewPager();

    }

    @Override
    public void setListener() {
        mMainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //切换tab标签
                changeTabs(position);
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
        //添加tab标签
        tabs.add(mBarNet);
        tabs.add(mBarMusic);
        tabs.add(mBarFriends);

        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new OfflineFragment());
        adapter.addFragment(new DiscoverFragment());
        adapter.addFragment(new MineFragment());

        mMainViewpager.setAdapter(adapter);
        mMainViewpager.setCurrentItem(1);
    }

    /**
     * 设置tab标签状态
     *
     * @param position
     */
    private void changeTabs(int position) {
        for (int i = 0; i < tabs.size(); i++) {
            if (position == i) {
                tabs.get(i).setSelected(true);
            } else {
                tabs.get(i).setSelected(false);
            }
        }
    }

    @OnClick({R.id.bar_music, R.id.bar_offline, R.id.bar_mine, R.id.bar_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bar_music:
                mMainViewpager.setCurrentItem(1);
                break;
            case R.id.bar_offline:
                mMainViewpager.setCurrentItem(0);
                break;
            case R.id.bar_mine:
                mMainViewpager.setCurrentItem(2);
                break;
            case R.id.bar_search:
                showToast("搜索待实现");
                break;
        }
    }

    //    /**
    //     * 双击返回桌面
    //     *
    //     * @param keyCode
    //     * @param event
    //     * @return
    //     */
    //    @Override
    //    public boolean onKeyDown(int keyCode, KeyEvent event) {
    //        if (keyCode == KeyEvent.KEYCODE_BACK) {
    //            if (System.currentTimeMillis() - time > 1000) {
    //                Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
    //                time = System.currentTimeMillis();
    //            } else {
    //                Intent intent = new Intent(Intent.ACTION_MAIN);
    //                intent.addCategory(Intent.CATEGORY_HOME);
    //                startActivity(intent);
    //            }
    //            return true;
    //        } else {
    //            return super.onKeyDown(keyCode, event);
    //        }
    //    }
}
