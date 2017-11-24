package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;


/**
 * 解决横向滑动引起的SwipeRefreshLayout下拉事件冲突的SwipeRefreshLayout
 *
 * @author gong.xl
 * @version 1.0.0
 * @date 2017/1/17  10:10
 * @copyright wonhigh.cn
 */
public class CustomSwipeToRefresh extends SwipeRefreshLayout {

    private int mTouchSlop;
    private float mPrevX;

    public CustomSwipeToRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);

        //获取系统的一个常量值
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录按下点的X位置
                mPrevX = MotionEvent.obtain(event).getX();
                break;

            case MotionEvent.ACTION_MOVE:
                //获取移动时的X位置
                final float eventX = event.getX();

                //计算两点之间的绝对值
                float xDiff = Math.abs(eventX - mPrevX);

                //当这个差值大于常量值时，认为这是一个横向滑动事件
                if (xDiff > mTouchSlop) {

                    //使之不拦截
                    return false;
                }
                break;
            default:
                break;
        }

        return super.onInterceptTouchEvent(event);
    }
}