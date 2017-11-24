package com.ilynn.kaolafm.ui.activity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.ilynn.base.BaseActivity;
import com.ilynn.base.view.NavigationBar;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.fragment.DiscoverFragment;
import com.ilynn.kaolafm.ui.fragment.HomeFragment;
import com.ilynn.kaolafm.ui.fragment.MineFragment;
import com.ilynn.kaolafm.ui.fragment.OfflineFragment;

import butterknife.InjectView;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/20 下午4:51
 * 修改日期: 2017/11/20
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class Main2Activity extends BaseActivity {


    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @InjectView(R.id.main_bar)
    NavigationBar mMainBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
    }


    @Override
    public void onInstanceState(Bundle savedIntanceState) {
        mMainBar.onRestoreInstanceState(savedIntanceState);
    }

    @Override
    public void initViews() {
        mMainBar.setFrameLayoutId(R.id.contentLayout);

        mMainBar.addTab(HomeFragment.class, new NavigationBar.TabParam(R.drawable.btn_manage_normal, R.drawable
                .btn_manage_press, "首页"));

        mMainBar.addTab(DiscoverFragment.class, new NavigationBar.TabParam(R.drawable.btn_discover_normal, R.drawable
                .btn_discover_press, "发现"));
        mMainBar.addTab(OfflineFragment.class, new NavigationBar.TabParam(R.drawable.btn_offline_normal, R.drawable
                .btn_offline_press, "离线"));
        mMainBar.addTab(MineFragment.class, new NavigationBar.TabParam(R.drawable.btn_mine_normal, R.drawable
                .btn_mine_press, "我的"));
    }


    @Override
    public void initData() {
    }

    @Override
    public void setListener() {
    }


    @Override
    public void onKeyBack() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    /**
     * 保存数据状态
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMainBar.onSaveInstanceState(outState);
    }
}
