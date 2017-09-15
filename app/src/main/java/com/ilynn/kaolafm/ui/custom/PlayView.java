package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.ilynn.kaolafm.R;

/**
 * 描述：全局显示的播放按钮
 * 作者：gong.xl
 * 创建日期：2017/9/15 下午2:48
 * 修改日期: 2017/9/15
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class PlayView extends LinearLayout {
    /**
     * 播放
     */
    public static int STATE_PLAY = 1;
    /**
     * 暂停
     */
    public static int STATE_PAUSE = 2;

    /**
     * 停止
     */
    public static int STATE_STOP = 3;

    private int state;          //当前播放状态
    private Context mContext;

    public PlayView(Context context) {
        super(context);
        init(context);
    }

    public PlayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化控件
     *
     * @param context
     */
    private void init(Context context) {
        this.mContext = context;
        inflate(context, R.layout.layout_paly_view,this);
    }
}
