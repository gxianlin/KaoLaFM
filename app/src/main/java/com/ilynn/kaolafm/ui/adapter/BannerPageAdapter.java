package com.ilynn.kaolafm.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/15 下午4:43
 * 修改日期: 2017/9/15
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BannerPageAdapter extends PagerAdapter {
    private ArrayList<ImageView> mImageViews;

    public BannerPageAdapter(Context context, DataListBean<List<Special>> item) {
        mImageViews = new ArrayList<>();
        List<Special> dataList = item.getDataList();
        for (int i = 0, j = dataList.size(); i < j; i++) {
            ImageView iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageUtil.GlideWith(context, dataList.get(i).getPic(), R.mipmap.ic_launcher, iv);
            mImageViews.add(iv);
        }
    }

    @Override
    public int getCount() {
        return mImageViews == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= mImageViews.size();
        if (position < 0) {
            position = mImageViews.size() + position;
        }
        ImageView iv = mImageViews.get(position);

        ViewParent parent = iv.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.removeAllViews();
        }
        container.addView(iv);
        return iv;
    }

}
