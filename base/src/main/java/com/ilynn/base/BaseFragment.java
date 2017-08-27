package com.ilynn.base;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilynn.base.util.Logger;

/**
 * 描述：基础fragment
 *      集合懒加载模式
 * 作者：gong.xl
 * 创建日期：2017/8/22 下午5:48
 * 修改日期: 2017/8/22
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class BaseFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();

    protected Context mContext;
    private SparseArray<View> mViews;
    private View mMainView;

    private boolean isVisible   = false;
    private boolean isInitView  = false;
    private boolean isFirstLoad = true;

    /**
     * 设置页面布局文件
     *
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d(TAG,"onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Logger.d(TAG,"onCreateView()");
        mViews = new SparseArray<>();
        if (mMainView == null){
            mMainView = inflater.inflate(getContentView(),container,false);
        }
        initView();
        isInitView = true;
        lazyLoad();
        return mMainView;
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
     * 懒加载
     */
    private void lazyLoad() {
        if (!isFirstLoad || !isVisible || !isInitView) {
            //如果不是第一次加载、不是可见、不是初始化view，则不加载数据
            return;
        }
        //加载数据
        initData();

        setListener();
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
            view = (E) mMainView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d(TAG,"onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(TAG,"onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(TAG,"onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d(TAG,"onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(TAG,"onDestroy()");
    }
}
