package com.ilynn.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.View;

import com.ilynn.base.util.Logger;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/22 下午5:48
 * 修改日期: 2017/8/22
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class BaseFragmentActivity extends FragmentActivity {
    private final String TAG = getClass().getSimpleName();

    private SparseArray<View> mViews;

    /**
     * 设置页面布局文件
     * @return 布局xml
     */
    protected abstract int getContentView();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置监听事件
     */
    protected abstract void setListener();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d(TAG,"onCreate()");
        setContentView(getContentView());
        mViews = new SparseArray<>();
        initView();
        initData();
        setListener();
    }

    /**
     * 通过id找到view
     *
     * @param viewId
     * @param <E>
     * @return
     */
    public <E extends View> E findView(int viewId) {
        E view = (E) mViews.get(viewId);
        if (view == null) {
            view = (E) findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(TAG,"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(TAG,"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(TAG,"onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d(TAG,"onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(TAG,"onDestroy()");
    }
}
