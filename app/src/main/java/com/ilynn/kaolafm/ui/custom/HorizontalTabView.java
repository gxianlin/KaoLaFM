package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ilynn.base.util.DensityUtil;
import com.ilynn.kaolafm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：自定义tab菜单栏
 * 作者：gong.xl
 * 创建日期：2017/11/24 下午3:30
 * 修改日期: 2017/11/24
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class HorizontalTabView extends HorizontalScrollView implements View.OnClickListener, ViewPager
        .OnPageChangeListener {
    private Context mContext;

    //小滑块
    private View mSlipView;

    //tabs容器
    private LinearLayout mTabsLayout;

    //tabs数据(tab名称集合)
    private List<String> mTabs;

    //tab控件经济和
    private List<TextView> mTabViews;

    //滑块及选中字体颜色
    private int mSlipColor;

    //默认字体颜色
    private int mTextColor;

    //tab单个宽度
    private int mSlipWidth;
    //tab高度
    private int mSlipHeight;

    //上一个选中的tabs
    private int mLastPosition;

    //绑定的viewPager
    private ViewPager mViewPager;

    //每个tab宽度
    private int mTabWidth;

    //小滑块指示器属性
    private LinearLayout.LayoutParams mSlipParams;

    public HorizontalTabView(Context context) {
        this(context, null);
    }

    public HorizontalTabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

        mSlipWidth = DensityUtil.dp2px(10);
        mSlipHeight = DensityUtil.dp2px(3);
        mSlipColor = context.getResources().getColor(R.color.head_bg);
        mTextColor = context.getResources().getColor(R.color.text_color_2);
        int mWidthDp = DensityUtil.getScreenWidthDp(context);
        mTabWidth = DensityUtil.dp2px(mWidthDp / 5);
        addView(getLineaLayout());
    }

    /**
     * 创建一个父容器
     *
     * @return
     */
    private LinearLayout getLineaLayout() {
        //创建一个容器
        LinearLayout parent = new LinearLayout(mContext);
        //        parent.setWeightSum(10);
        //设置方向
        parent.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                .MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        parent.setLayoutParams(layoutParams);

        //创建存放tabs的容器
        mTabsLayout = new LinearLayout(mContext);
        mTabsLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 0);
        tabParams.weight = 1;

        mTabsLayout.setLayoutParams(tabParams);

        //创建小滑块
        mSlipView = new View(mContext);
        LinearLayout.LayoutParams slipParams = new LinearLayout.LayoutParams(DensityUtil.dp2px(50), DensityUtil.dp2px
                (5));
        slipParams.leftMargin = DensityUtil.dp2px(25);
        slipParams.topMargin = DensityUtil.dp2px(-7);
        mSlipView.setLayoutParams(slipParams);
        parent.addView(mTabsLayout);
        parent.addView(mSlipView);

        return parent;
    }


    /**
     * 设置数据
     *
     * @param tabs tabs数据
     */
    public void setTabs(List<String> tabs) {
        setTabs(tabs, 0);
    }

    /**
     * 设置数据
     *
     * @param tabs     tabs数据
     * @param position 默认选中
     */
    public void setTabs(List<String> tabs, int position) {
        this.mTabs = tabs;
        mLastPosition = position;
        addTabs(position);
    }


    private void addTabs(int position) {

        //设置滑块属性
        int length = mTabs.get(position).length();
        mSlipParams = (LinearLayout.LayoutParams) mSlipView.getLayoutParams();
        mSlipParams.width = mSlipWidth * length;
        mSlipParams.height = mSlipHeight;
        mSlipParams.leftMargin = (mTabWidth * position) + (mTabWidth - mSlipParams.width) / 2;
        mSlipView.setLayoutParams(mSlipParams);
        mSlipView.setBackgroundColor(mSlipColor);

        //添加tab
        mTabViews = new ArrayList<>();
        mTabsLayout.removeAllViews();
        for (int i = 0; i < mTabs.size(); i++) {
            TextView tab = new TextView(mContext);
            LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams(mTabWidth, LinearLayout
                    .LayoutParams.MATCH_PARENT);
            tab.setLayoutParams(tabParams);
            tab.setTextSize(15);
            tab.setGravity(Gravity.CENTER);
            if (i == position) {
                tab.setTextColor(mSlipColor);
            } else {
                tab.setTextColor(mTextColor);
            }
            tab.setTag(i);
            tab.setText(mTabs.get(i));
            tab.setOnClickListener(this);
            mTabsLayout.addView(tab);
            mTabViews.add(tab);
        }
    }


    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (position == mLastPosition) {
            return;
        }

        //获取点击的按钮
        mTabViews.get(position).setTextColor(mSlipColor);
        mTabViews.get(mLastPosition).setTextColor(mTextColor);

        if (mViewPager != null) {
            mViewPager.setCurrentItem(position);
        }

        mLastPosition = position;
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffsetPixels != 0) {
            int lengthCurren = mTabs.get(position).length();
            int lengthNext = mTabs.get(position + 1).length();
            mSlipParams.leftMargin = (int) (mTabWidth * (position + positionOffset) + (mTabWidth - mSlipParams
                    .width) / 2);
            mSlipParams.width = (int) (mSlipWidth * (lengthCurren + (lengthNext - lengthCurren) * positionOffset));
            mSlipView.setLayoutParams(mSlipParams);
        }
    }

    @Override
    public void onPageSelected(int position) {
        mTabViews.get(position).setTextColor(mSlipColor);
        mTabViews.get(mLastPosition).setTextColor(mTextColor);
        mLastPosition = position;
        //设置水平滚动条滚动,使得当标题过多是,滑动不会滑动到屏幕之外
        smoothScrollTo((position - 2) * mTabWidth, 0);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
