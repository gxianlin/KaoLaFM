package com.ilynn.kaolafm.ui.adapter;

import android.support.v4.view.ViewPager;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.config.LayoutType;

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
        addItemType(LayoutType.BANNER, R.layout.layout_header_bannder);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataListBean<List<Special>> item) {
        //轮播图
        ViewPager viewpager = helper.getView(R.id.header_viewpager);
        viewpager.setAdapter(new BannerPageAdapter(mContext, item.getDataList()));
        viewpager.setCurrentItem(Integer.MAX_VALUE / 2);//默认在中间，使用户看不到边界
    }
}
