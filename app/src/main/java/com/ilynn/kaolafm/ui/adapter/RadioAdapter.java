package com.ilynn.kaolafm.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.Special;

import java.util.List;

/**
 * 描述：主播页面适配器
 * 作者：gong.xl
 * 创建日期：2017/9/21 下午1:48
 * 修改日期: 2017/9/21
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RadioAdapter extends BaseMultiItemQuickAdapter<DataListBean<List<Special>>, BaseViewHolder> {

    public RadioAdapter(List<DataListBean<List<Special>>> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataListBean<List<Special>> item) {

    }
}
