package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilynn.kaolafm.R;

/**
 * 描述：上拉加载控件
 * 作者：gong.xl
 * 创建日期：2017/11/28 上午10:04
 * 修改日期: 2017/11/28
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class RVLoadMoreView extends RVStatusView {
    private TextView mTextView;
    private ImageView mImageView;


    public RVLoadMoreView(Context context) {
        this(context, null);
    }

    public RVLoadMoreView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RVLoadMoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mTextView = (TextView) findViewById(R.id.load_text);
        mImageView = (ImageView) findViewById(R.id.load_image);
    }

    @Override
    public int setLayout() {
        return R.layout.layout_load_view;
    }

    @Override
    public void onLoading() {
        super.onLoading();

        mImageView.setVisibility(VISIBLE);

        mTextView.setText("正在努力加载...");
//        mImageView.setImageResource(R.drawable.loading);
//        ((AnimationDrawable) mImageView.getDrawable()).start();
    }

    @Override
    public void onFinish() {
        super.onFinish();
        mImageView.setVisibility(VISIBLE);

        mTextView.setText("加载完成");
//        Drawable drawable = mImageView.getDrawable();
//        if (drawable instanceof AnimationDrawable) {
//            ((AnimationDrawable) drawable).stop();
//        }
    }

    @Override
    public void onPulling(int percent) {
        super.onPulling(percent);
        // TODO 在这里设置下拉过程效果

        mImageView.setVisibility(VISIBLE);

        mTextView.setText("上拉加载更多");
//        if (percent < 20) {
//            mImageView.setImageResource(R.drawable.pull_end_image_frame_01);
//        } else if (percent < 40) {
//            mImageView.setImageResource(R.drawable.pull_end_image_frame_02);
//        } else if (percent < 60) {
//            mImageView.setImageResource(R.drawable.pull_end_image_frame_03);
//        } else if (percent < 80) {
//            mImageView.setImageResource(R.drawable.pull_end_image_frame_04);
//        } else {
//            mImageView.setImageResource(R.drawable.pull_end_image_frame_05);
//        }
    }

    @Override
    public void onLoosen() {
        super.onLoosen();
        // TODO 在这里设置释放加载效果

        mImageView.setVisibility(VISIBLE);
        mTextView.setText("释放加载更多");
    }

    @Override
    public void onTips() {
        super.onTips();
        // TODO 在这里设置提示信息
        mImageView.setVisibility(GONE);
        mTextView.setText("点击加载更多");
    }
}
