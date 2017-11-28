package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilynn.kaolafm.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：下拉刷新控件
 * 作者：gong.xl
 * 创建日期：2017/11/28 上午10:27
 * 修改日期: 2017/11/28
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class RVRefreshView extends RVStatusView {
    private TextView tvTime;
    private TextView tvHint;
    private ImageView iv;

    public RVRefreshView(Context context) {
        this(context, null);
    }

    public RVRefreshView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RVRefreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        tvTime = (TextView) findViewById(R.id.refresh_time);
        tvHint = (TextView) findViewById(R.id.refresh_text);
        iv = (ImageView) findViewById(R.id.refresh_image);
    }

    @Override
    public int setLayout() {
        return R.layout.layout_refresh_view;
    }

    @Override
    public void onLoading() {
        super.onLoading();
        // TODO 在这里设置正在加载效果

        tvHint.setText("正在刷新");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(new Date(System.currentTimeMillis()));
        tvTime.setText("上一次刷新时间:" + time);
        //        iv.setImageResource(R.drawable.loading);
        //        ((AnimationDrawable) iv.getDrawable()).start();

    }

    @Override
    public void onFinish() {
        super.onFinish();

        tvHint.setText("刷新完成");
        //        Drawable drawable = iv.getDrawable();
        //        if (drawable instanceof AnimationDrawable) {
        //            ((AnimationDrawable) drawable).stop();
        //        }
    }

    @Override
    public void onPulling(int percent) {
        super.onPulling(percent);
        // TODO 在这里设置下拉过程效果

        tvHint.setText("下拉可以刷新");
        //        if (percent < 20) {
        //            iv.setImageResource(R.drawable.pull_end_image_frame_01);
        //        } else if (percent < 40) {
        //            iv.setImageResource(R.drawable.pull_end_image_frame_02);
        //        } else if (percent < 60) {
        //            iv.setImageResource(R.drawable.pull_end_image_frame_03);
        //        } else if (percent < 80) {
        //            iv.setImageResource(R.drawable.pull_end_image_frame_04);
        //        } else {
        //            iv.setImageResource(R.drawable.pull_end_image_frame_05);
        //        }
    }

    @Override
    public void onLoosen() {
        super.onLoosen();
        tvHint.setText("释放刷新");
    }

}
