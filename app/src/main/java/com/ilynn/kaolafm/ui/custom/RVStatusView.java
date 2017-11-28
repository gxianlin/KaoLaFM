package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * 描述：用于封装一些状态的View
 * 作者：gong.xl
 * 创建日期：2017/11/28 上午10:05
 * 修改日期: 2017/11/28
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class RVStatusView extends FrameLayout {
    /**
     * 加载中
     */
    public static final int STATUS_LOADING = 0xAAA1;
    /**
     * 松开以加载
     */
    public static final int STATUS_LOOSEN = 0xAAA2;
    /**
     * 下拉中
     */
    public static final int STATUS_PULLING = 0xAAA3;
    /**
     * 加载完成
     */
    public static final int STATUS_FINISH = 0xAAA4;
    /**
     * 加载更多提示、数据不足一页时展示
     */
    public static final int STATUS_TIPS = 0xAAA5;

    /**
     * 标记-控件状态
     */
    protected int status;


    public RVStatusView(Context context) {
        this(context, null);
    }

    public RVStatusView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RVStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 加载布局
        LayoutInflater.from(context).inflate(setLayout(), this, true);
    }

    /**
     * 设置布局
     *
     * @return 布局
     */
    @LayoutRes
    public abstract int setLayout();


    /**
     * 正在加载中
     */
    public void onLoading() {
        setStatus(STATUS_LOADING);
    }

    /**
     * 松开以加载
     */
    public void onLoosen() {
        setStatus(STATUS_LOOSEN);
    }

    /**
     * 下拉状态
     *
     * @param percent 下拉进度 <p>单位：百分比</p> <p>范围：0~100</p>
     */
    public void onPulling(int percent) {
        setStatus(STATUS_PULLING);
    }

    /**
     * 加载完成
     */
    public void onFinish() {
        setStatus(STATUS_FINISH);
    }

    /**
     * 数据不足一页时加载更多显示
     */
    public void onTips() {
        setStatus(STATUS_TIPS);
    }

    /**
     * 设置状态
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 获取状态
     */
    public int getStatus() {
        return status;
    }
}
