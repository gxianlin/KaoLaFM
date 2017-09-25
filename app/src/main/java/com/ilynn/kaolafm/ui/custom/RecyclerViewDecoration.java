package com.ilynn.kaolafm.ui.custom;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ilynn.base.util.DensityUtil;

/**
 * 描述：RecyclerView分割线
 * 只是简单的处理,配合布局RecyclerView设置背景使用
 *
 * 作者：gong.xl
 * 创建日期：2017/9/21 下午1:58
 * 修改日期: 2017/9/21
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class RecyclerViewDecoration extends RecyclerView.ItemDecoration {
    /**
     * @param outRect 边界
     * @param view    recyclerView ItemView
     * @param parent  recyclerView
     * @param state   recycler 内部数据管理
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //设定底部边距为1px
        outRect.set(0, 0, 0, DensityUtil.dp2px(10));
    }
}
