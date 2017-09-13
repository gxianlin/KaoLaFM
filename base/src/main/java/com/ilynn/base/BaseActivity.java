package com.ilynn.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.ilynn.base.util.LogUtils;
import com.ilynn.base.util.StatusBarUtil;

import butterknife.ButterKnife;

/**
 * 描述：通用基础activity
 * 作者：gong.xl
 * 创建日期：2017/8/22 下午5:47
 * 修改日期: 2017/8/22
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected final String TAG = getClass().getSimpleName();
    private SparseArray<View> mViews;

    /**
     * 绑定布局文件
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化视图控件
     */
    public abstract void initViews();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 设置控件监听事件
     */
    public abstract void setListener();


    @Override
    protected void onCreate(@Nullable Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        LogUtils.d(TAG, "onCreate()");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mViews = new SparseArray<>();
        setContentView(getLayoutId());
        setStatusBar();
        ButterKnife.inject(this);
        receiveData();
        initViews();
        setListener();
        initData();
    }
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.head_bg),0);
    }

    /**
     * 用于接收参数
     */
    protected void receiveData() {

    }

    /**
     * 点击事件回调
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

    }

    /**
     * 显示Snackbar
     *
     * @param view
     * @param text
     */
    public void showSnackBar(View view, @Nullable String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * 显示Snackbar
     *
     * @param view
     * @param resID
     */
    public void showSnackBar(View view, int resID) {
        Snackbar.make(view, resID, Snackbar.LENGTH_SHORT).show();
    }

    /***
     * 跳转页面
     */
    public void startToActivity(Class activity) {
        Intent intent = new Intent();
        intent.setClass(this, activity);
        startActivity(intent);
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

    public void showToast(int toastRes) {
        Toast.makeText(this, getString(toastRes), Toast.LENGTH_SHORT).show();
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 设置view的点击事件
     *
     * @param view
     * @param <E>
     */
    public <E extends View> void setOnClick(E view) {
        view.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d(TAG, "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d(TAG, "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d(TAG, "onDestroy()");
    }
}
