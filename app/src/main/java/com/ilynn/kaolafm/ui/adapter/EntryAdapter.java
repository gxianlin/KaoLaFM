package com.ilynn.kaolafm.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.Special;

import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/18 下午1:22
 * 修改日期: 2017/9/18
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class EntryAdapter extends BaseQuickAdapter<Special, BaseViewHolder> {

    public EntryAdapter(@Nullable List<Special> data, RecyclerView recyclerView) {
        super(R.layout.item_entry, data);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
    }


    @Override
    protected void convert(BaseViewHolder helper, Special item) {
        helper.addOnClickListener(R.id.entry_layout);
        Glide.with(mContext)
                .load(item.getPic())
                .into((ImageView) helper.getView(R.id.entry_iv));
    }
}
