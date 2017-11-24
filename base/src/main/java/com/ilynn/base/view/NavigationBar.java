package com.ilynn.base.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ilynn.base.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：自定义app导航栏
 * 作者：gong.xl
 * 创建日期：2017/11/13 下午2:35
 * 修改日期: 2017/11/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class NavigationBar extends LinearLayout implements View.OnClickListener {
    private static final String KEY_CURRENT_TAG = "com.startsmake.template.currentTag";

    private OnTabSelectedListener mTabSelectListener;
    private OnTabChangeListener mTabChangeListener;
    private FragmentActivity mFragmentActivity;


    /**
     * 菜单集合
     */
    private List<ViewHolder> mViewHolderList;

    //当前
    private String mCurrentTag;

    //需要恢复
    private String mRestoreTag;

    /**
     * tab选中字体的颜色
     */
    private ColorStateList mSelectedTextColor;

    /**
     * tab默认字体颜色
     */
    private ColorStateList mNormalTextColor;

    /**
     * tab字体大小
     */
    private int mTabTextSize;

    /**
     * 默认选中的tab
     */
    private int mDefaultSelectedTab = 0;

    /**
     * 主内容显示区域View的id
     */
    private int mMainContentLayoutId;

    /**
     * 当前选中的页面
     */
    private int mCurrentSelectedTab;


    public NavigationBar(Context context) {
        this(context, null);
    }

    public NavigationBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义属性
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.NavigateBar, 0, 0);
        ColorStateList tabTextColor = typedArray.getColorStateList(R.styleable.NavigateBar_navigateTabTextColor);
        ColorStateList selectedTabTextColor = typedArray.getColorStateList(R.styleable
                .NavigateBar_navigateTabSelectedTextColor);

        mTabTextSize = typedArray.getDimensionPixelSize(R.styleable.NavigateBar_navigateTabTextSize, 0);
        mNormalTextColor = (tabTextColor != null ? tabTextColor : context.getResources().getColorStateList(R.color
                .tab_text_normal));
        mSelectedTextColor = (selectedTabTextColor != null ? selectedTabTextColor : context.getResources()
                .getColorStateList(R.color.tab_text_selected));

//        mMainContentLayoutId = typedArray.getResourceId(R.styleable.NavigateBar_containerId, 0);

        mViewHolderList = new ArrayList<>();
    }


    /**
     * 添加导航菜单
     *
     * @param frameLayoutClass fragment
     * @param tabParam         菜单
     */
    public void addTab(Class frameLayoutClass, TabParam tabParam) {
        int defaultLayout = R.layout.navigation_tab_view;

        if (TextUtils.isEmpty(tabParam.title)) {
            tabParam.title = getContext().getString(tabParam.titleStringRes);
        }

        View view = LayoutInflater.from(getContext()).inflate(defaultLayout, null);
        view.setFocusable(true);

        ViewHolder holder = new ViewHolder();

        holder.tabIndex = mViewHolderList.size();

        holder.fragmentClass = frameLayoutClass;
        holder.tag = tabParam.title;
        holder.pageParam = tabParam;

        holder.tabIcon = (ImageView) view.findViewById(R.id.tab_icon);
        holder.tabTitle = ((TextView) view.findViewById(R.id.tab_title));

        if (TextUtils.isEmpty(tabParam.title)) {
            holder.tabTitle.setVisibility(View.INVISIBLE);
        } else {
            holder.tabTitle.setText(tabParam.title);
        }

        if (mTabTextSize != 0) {
            holder.tabTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTabTextSize);
        }
        if (mNormalTextColor != null) {
            holder.tabTitle.setTextColor(mNormalTextColor);
        }

        if (tabParam.backgroundColor > 0) {
            view.setBackgroundResource(tabParam.backgroundColor);
        }

        if (tabParam.iconResId > 0) {
            holder.tabIcon.setImageResource(tabParam.iconResId);
        } else {
            holder.tabIcon.setVisibility(View.INVISIBLE);
        }

        if (tabParam.iconResId > 0 && tabParam.iconSelectedResId > 0) {
            view.setTag(holder);
            view.setOnClickListener(this);
            mViewHolderList.add(holder);
        }

        //添加
        addView(view, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0F));

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mMainContentLayoutId == 0) {
            throw new RuntimeException("mFrameLayoutId Cannot be 0");
        }
        if (mViewHolderList.size() == 0) {
            throw new RuntimeException("mViewHolderList.size Cannot be 0, Please call addTab()");
        }
        if (!(getContext() instanceof FragmentActivity)) {
            throw new RuntimeException("parent activity must is extends FragmentActivity");
        }
        mFragmentActivity = (FragmentActivity) getContext();

        ViewHolder defaultHolder = null;

        hideAllFragment();
        if (!TextUtils.isEmpty(mRestoreTag)) {
            for (ViewHolder holder : mViewHolderList) {
                if (TextUtils.equals(mRestoreTag, holder.tag)) {
                    defaultHolder = holder;
                    mRestoreTag = null;
                    break;
                }
            }
        } else {
            defaultHolder = mViewHolderList.get(mDefaultSelectedTab);
        }

        showFragment(defaultHolder);
    }

    @Override
    public void onClick(View v) {
        Object object = v.getTag();
        //判断被点击的View是否是我们定义的ViewHolder
        if (object != null && object instanceof ViewHolder) {

            ViewHolder holder = (ViewHolder) v.getTag();
            //显示点击菜单对应的fragment
            showFragment(holder);

            //如果设置了点击监听事件则回调
            if (mTabSelectListener != null) {
                mTabSelectListener.onTabSelected(holder);
            }

            if (mTabChangeListener != null) {
                mTabChangeListener.onTabSelected(holder.tabIndex);
            }
        }
    }

    /**
     * 显示 holder 对应的 fragment
     *
     * @param holder
     */
    public void showFragment(ViewHolder holder) {
        //获取事物
        FragmentTransaction transaction = mFragmentActivity.getSupportFragmentManager().beginTransaction();
        if (isFragmentShown(transaction, holder.tag)) {
            return;
        }

        setCurrSelectedTabByTag(holder.tag);

        Fragment fragment = mFragmentActivity.getSupportFragmentManager().findFragmentByTag(holder.tag);
        if (fragment == null) {
            fragment = getFragmentInstance(holder.tag);
            transaction.add(mMainContentLayoutId, fragment, holder.tag);
        } else {
            transaction.show(fragment);
        }
        transaction.commit();
        mCurrentSelectedTab = holder.tabIndex;
    }

    /**
     * 判断fragment是否正在显示
     *
     * @param transaction
     * @param newTag
     * @return
     */
    private boolean isFragmentShown(FragmentTransaction transaction, String newTag) {
        if (TextUtils.equals(newTag, mCurrentTag)) {
            return true;
        }

        if (TextUtils.isEmpty(mCurrentTag)) {
            return false;
        }

        Fragment fragment = mFragmentActivity.getSupportFragmentManager().findFragmentByTag(mCurrentTag);
        if (fragment != null && !fragment.isHidden()) {
            transaction.hide(fragment);
        }

        return false;
    }

    /**
     * 设置当前选中tab的图片和文字颜色
     */
    private void setCurrSelectedTabByTag(String tag) {
        if (TextUtils.equals(mCurrentTag, tag)) {
            return;
        }
        for (ViewHolder holder : mViewHolderList) {
            if (TextUtils.equals(mCurrentTag, holder.tag)) {
                holder.tabIcon.setImageResource(holder.pageParam.iconResId);
                holder.tabTitle.setTextColor(mNormalTextColor);
            } else if (TextUtils.equals(tag, holder.tag)) {
                holder.tabIcon.setImageResource(holder.pageParam.iconSelectedResId);
                holder.tabTitle.setTextColor(mSelectedTextColor);
            }
        }
        mCurrentTag = tag;
    }

    /**
     * 获取fragment
     *
     * @param tag
     * @return
     */
    private Fragment getFragmentInstance(String tag) {
        Fragment fragment = null;
        for (ViewHolder holder : mViewHolderList) {
            if (TextUtils.equals(tag, holder.tag)) {
                try {
                    fragment = (Fragment) Class.forName(holder.fragmentClass.getName()).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return fragment;
    }

    /**
     * 隐藏fragment
     */
    private void hideAllFragment() {
        if (mViewHolderList == null || mViewHolderList.size() == 0) {
            return;
        }

        FragmentTransaction transaction = mFragmentActivity.getSupportFragmentManager().beginTransaction();

        for (ViewHolder holder : mViewHolderList) {
            Fragment fragment = mFragmentActivity.getSupportFragmentManager().findFragmentByTag(holder.tag);
            if (fragment != null && !fragment.isHidden()) {
                transaction.hide(fragment);
            }
        }
        transaction.commit();
    }

    /**
     * 设置选中文字颜色
     *
     * @param selectedTextColor
     */
    public void setSelectedTabTextColor(ColorStateList selectedTextColor) {
        mSelectedTextColor = selectedTextColor;
    }

    /**
     * 设置选中文字颜色
     *
     * @param selectedTextColor
     */
    public void setSelectedTabTextColor(int selectedTextColor) {
        mSelectedTextColor = ColorStateList.valueOf(selectedTextColor);
    }

    /**
     * 设置默认文字颜色
     *
     * @param color
     */
    public void setTabTextColor(ColorStateList color) {
        mNormalTextColor = color;
    }

    /**
     * 设置默认文字颜色
     *
     * @param color
     */
    public void setTabTextColor(int color) {
        mNormalTextColor = ColorStateList.valueOf(color);
    }

    /**
     * 设置id
     *
     * @param frameLayoutId
     */
    public void setFrameLayoutId(int frameLayoutId) {
        mMainContentLayoutId = frameLayoutId;
    }


    /**
     * 恢复状态
     *
     * @param savedInstanceState
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mRestoreTag = savedInstanceState.getString(KEY_CURRENT_TAG);
        }
    }

    /**
     * 保存状态
     *
     * @param outState
     */
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_CURRENT_TAG, mCurrentTag);
    }

    /**
     * 菜单ViewHolder
     */
    public static class ViewHolder {
        public String tag;
        public TabParam pageParam;
        public ImageView tabIcon;
        public TextView tabTitle;
        public Class fragmentClass;
        public int tabIndex;
    }


    /**
     * 导航栏菜单属性
     */
    public static class TabParam {
        public int backgroundColor = android.R.color.white;
        public int iconResId;
        public int iconSelectedResId;
        public int titleStringRes;
        public String title;

        /**
         * 创建一个菜单
         *
         * @param iconResId         默认图片
         * @param iconSelectedResId 选中图片
         * @param title             名称
         */
        public TabParam(int iconResId, int iconSelectedResId, String title) {
            this.iconResId = iconResId;
            this.iconSelectedResId = iconSelectedResId;
            this.title = title;
        }

        /**
         * 创建一个菜单
         *
         * @param iconResId         默认图片
         * @param iconSelectedResId 选中图片
         * @param titleStringRes    名称
         */
        public TabParam(int iconResId, int iconSelectedResId, int titleStringRes) {
            this.iconResId = iconResId;
            this.iconSelectedResId = iconSelectedResId;
            this.titleStringRes = titleStringRes;
        }

        /**
         * 创建一个菜单
         *
         * @param backgroundColor   背景色
         * @param iconResId         默认图片
         * @param iconSelectedResId 选中图片
         * @param titleStringRes    名称
         */
        public TabParam(int backgroundColor, int iconResId, int iconSelectedResId, int titleStringRes) {
            this.backgroundColor = backgroundColor;
            this.iconResId = iconResId;
            this.iconSelectedResId = iconSelectedResId;
            this.titleStringRes = titleStringRes;
        }

        /**
         * 创建一个菜单
         *
         * @param backgroundColor   背景色
         * @param iconResId         默认图片
         * @param iconSelectedResId 选中图片
         * @param title             名称
         */
        public TabParam(int backgroundColor, int iconResId, int iconSelectedResId, String title) {
            this.backgroundColor = backgroundColor;
            this.iconResId = iconResId;
            this.iconSelectedResId = iconSelectedResId;
            this.title = title;
        }
    }


    /**
     * tab点击监听事件
     */
    public interface OnTabSelectedListener {
        void onTabSelected(ViewHolder holder);
    }

    /**
     * tab点击监听事件
     */
    public interface OnTabChangeListener {
        void onTabSelected(int position);
    }

    /**
     * 设置tab改变监听
     *
     * @param tabSelectListener
     */
    public void setTabSelectListener(OnTabSelectedListener tabSelectListener) {
        mTabSelectListener = tabSelectListener;
    }

    /**
     * 设置tab改变监听
     *
     * @param onTabChangeListener
     */
    public void setTabSelectListener(OnTabChangeListener onTabChangeListener) {
        mTabChangeListener = onTabChangeListener;
    }

    /**
     * 设置默认选中
     *
     * @param index
     */
    public void setDefaultSelectedTab(int index) {
        if (index >= 0 && index < mViewHolderList.size()) {
            mDefaultSelectedTab = index;
        }
    }

    /**
     * 设置默认选中
     *
     * @param index 选中第几项
     */
    public void setCurrentSelectedTab(int index) {
        if (index >= 0 && index < mViewHolderList.size()) {
            ViewHolder holder = mViewHolderList.get(index);
            showFragment(holder);
        }
    }

    /**
     * 获取当前选中
     *
     * @return 返回当前选中的索引
     */
    public int getCurrentSelectedTab() {
        return mCurrentSelectedTab;
    }

}
