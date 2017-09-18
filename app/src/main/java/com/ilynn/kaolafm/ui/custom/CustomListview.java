package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/18 下午4:08
 * 修改日期: 2017/9/18
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class CustomListview extends ListView {
    private int mPosition;

    public CustomListview(Context context) {
        super(context);
    }

    public CustomListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, measureSpec);
    }

    //重写此方法，屏蔽ListView的滑动
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        final int actionMasked = ev.getActionMasked() & MotionEvent.ACTION_MASK;
//
//        if (actionMasked == MotionEvent.ACTION_DOWN) {
//            // 记录手指按下时的位置
//            mPosition = pointToPosition((int) ev.getX(), (int) ev.getY());
//            return super.dispatchTouchEvent(ev);
//        }
//
//        if (actionMasked == MotionEvent.ACTION_MOVE) {
//            // 最关键的地方，忽略MOVE 事件
//            // ListView onTouch获取不到MOVE事件所以不会发生滚动处理
//            return true;
//        }
//
//        // 手指抬起时
//        if (actionMasked == MotionEvent.ACTION_UP
//                || actionMasked == MotionEvent.ACTION_CANCEL) {
//            // 手指按下与抬起都在同一个视图内，交给父控件处理，这是一个点击事件
//            if (pointToPosition((int) ev.getX(), (int) ev.getY()) == mPosition) {
//                super.dispatchTouchEvent(ev);
//            } else {
//                // 如果手指已经移出按下时的Item，说明是滚动行为，清理Item pressed状态
//                setPressed(false);
//                invalidate();
//                return true;
//            }
//        }
//
//        return super.dispatchTouchEvent(ev);
//    }
}
