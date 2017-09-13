package com.ilynn.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ilynn.base.util.LogUtils;

import butterknife.ButterKnife;

/**
 * 描述：通用基础fragmnet
 * 作者：gong.xl
 * 创建日期：2017/8/22 下午5:48
 * 修改日期: 2017/8/22
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    protected final String TAG = BaseFragment.class.getSimpleName();
    protected Context mContext;

    private boolean isVisible = false;
    private boolean isInitView = false;
    private boolean isFirstLoad = true;
    protected View contentView;
    private SparseArray<View> mViews;
    /**
     * 绑定布局文件
     * @return
     */
    public abstract int getLayoutId();


    /**
     * 初始化视图控件
     */
    public abstract void initViews();

    /**
     * 设置监听事件
     */
    public abstract void setListener();

    /**
     * 初始化数据
     */
    public abstract void initData();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d(TAG,"onCreate()");
        receiveData();
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LogUtils.d(TAG,"onCreateView()");
        mViews = new SparseArray<>();
        if (contentView == null) {
            contentView = inflater.inflate(getLayoutId(), container, false);
        }
        ButterKnife.inject(this, contentView);
        initViews();
        isInitView = true;
        lazyLoad();
        return contentView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
        }
    }

    /**
     * 用于接收参数
     */
    protected void receiveData() {

    }

    //懒加载
    protected void lazyLoad() {

        if (!isFirstLoad || !isVisible || !isInitView) {
            //如果不是第一次加载、不是可见、不是初始化view，则不加载数据
            return;
        }
        //加载数据
        setListener();
        initData();
        //设置已经不是第一次加载
        isFirstLoad = false;
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
            view = (E) contentView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }
    /***
     * 跳转页面
     */
    public void startToActivity(Class activity) {
        Intent intent = new Intent(getActivity(), activity);
        startActivity(intent);
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

    public void showToast(int toastRes){
        Toast.makeText(mContext, getString(toastRes), Toast.LENGTH_SHORT).show();
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

    /**
     * 跳转页面
     *
     * @param zClass activity
     */
    public void gotoActivity(Class zClass) {
        startActivity(new Intent(getContext(), zClass));
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {

    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.d(TAG,"onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.d(TAG,"onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.d(TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.d(TAG,"onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        LogUtils.d(TAG,"onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d(TAG,"onDestroy()");
    }
}
