package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ilynn.base.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/24 下午3:30
 * 修改日期: 2017/11/24
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class HorizontalTabView extends HorizontalScrollView {
    private Context mContext;

    //小滑块
    private View mSlipView;

    //tabs容器
    private LinearLayout mTabsLayout;

    //tabs数据(tab名称集合)
    private List<String> mTabs;

    //tab控件经济和
    private List<TextView> mTabViews;


    //测量字符串宽度的画笔
    private Paint mPaint;
    private int mPadding;

    public HorizontalTabView(Context context) {
        this(context, null);
    }

    public HorizontalTabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

        mPaint = new Paint();
        mPadding = DensityUtil.dp2px(10);
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
        LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
        tabParams.weight = 1;
        mTabsLayout.setLayoutParams(tabParams);

        //创建小滑块
        mSlipView = new View(mContext);
        LinearLayout.LayoutParams slipParams = new LinearLayout.LayoutParams(DensityUtil.dp2px(50), DensityUtil.dp2px
                (5));
        mSlipView.setBackgroundColor(Color.RED);
        mSlipView.setLayoutParams(slipParams);
        parent.addView(mTabsLayout);
//        parent.addView(mSlipView);

        return parent;
    }


    /**
     * 设置数据
     *
     * @param tabs
     */
    public void setTabs(List<String> tabs) {
        this.mTabs = tabs;
        addTabs();
    }

    private void addTabs() {
        mTabViews = new ArrayList<>();
        mTabsLayout.removeAllViews();
        for (int i = 0; i < mTabs.size(); i++) {
            TextView tab = new TextView(mContext);
            LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                    .WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            tab.setLayoutParams(tabParams);
            tab.setGravity(Gravity.CENTER);
            tab.setTextSize(14);
            tab.setPadding(mPadding, 0, mPadding, 0);
            tab.setText(mTabs.get(i));
            tab.setTextColor(Color.BLACK);
            mTabsLayout.addView(tab);
            mTabViews.add(tab);
        }
    }


    /**
     * 获取文本宽度
     *
     * @param text
     * @return
     */
    private int getTextWidth(String text) {
        Rect rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        return rect.width();
    }
}
