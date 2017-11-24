package com.ilynn.kaolafm.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.config.LayoutType;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：首页推荐页面多布局适配器
 * <p>
 * 作者：gong.xl
 * 创建日期：2017/9/14 下午2:44
 * 修改日期: 2017/9/14
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class RecommendAdapter extends BaseMultiItemQuickAdapter<DataListBean<List<Special>>, BaseViewHolder> {

    public RecommendAdapter(List<DataListBean<List<Special>>> data) {
        super(data);
        addItemType(LayoutType.BANNER, R.layout.layout_header_bannder);
        addItemType(LayoutType.ENTRY, R.layout.layout_entry);
        addItemType(LayoutType.SECTION_SQUARE, R.layout.layout_section_square);
        addItemType(LayoutType.SECTION_VERTICAL, R.layout.layout_section_vertical);
        addItemType(LayoutType.SECTION_MENU, R.layout.layout_section_menu);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataListBean<List<Special>> item) {
        switch (helper.getItemViewType()) {
            case LayoutType.BANNER:
                //轮播图
                Banner banner = helper.getView(R.id.banner);
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                //设置图片加载器
                banner.setImageLoader(new com.ilynn.kaolafm.utils.GlideImageLoader(true));

                //设置banner动画效果
                banner.setBannerAnimation(Transformer.DepthPage);

                //设置自动轮播，默认为true
                banner.isAutoPlay(true);
                //设置轮播时间
                banner.setDelayTime(2000);
                //设置指示器位置（当banner模式中有指示器时）
                banner.setIndicatorGravity(BannerConfig.RIGHT);

                ArrayList<String> imageList = new ArrayList<>();
                ArrayList<String> titles = new ArrayList<>();
                for (Special s : item.getDataList()) {
                    imageList.add(s.getPic());
                    titles.add(s.getDes());
                }

                //设置图片集合
                banner.setImages(imageList);

                //设置标题集合（当banner样式有显示title时）
                banner.setBannerTitles(titles);

                //banner设置方法全部调用完毕时最后调用
                banner.start();

                break;
            case LayoutType.ENTRY:
                //快捷入口
                RecyclerView entry_rv = helper.getView(R.id.entry_rv);
                entry_rv.setAdapter(new EntryAdapter(item.getDataList(), entry_rv));
                break;
            case LayoutType.SECTION_SQUARE:
                //标题名称
                helper.setText(R.id.title, item.getName());
                //是否显示 "更多"按钮
                if (item.getHasmore() == 1) {
                    helper.getView(R.id.title_more).setVisibility(View.VISIBLE);
                } else {
                    helper.getView(R.id.title_more).setVisibility(View.GONE);
                }
                GridView gv = helper.getView(R.id.gridview);
                gv.setAdapter(new SpecialAdapter(mContext, item.getDataList()));
                break;
            case LayoutType.SECTION_VERTICAL:
                //猜你喜欢
                ListView lv = helper.getView(R.id.listview);
                lv.setAdapter(new GuessAdapter(mContext, item.getDataList()));
                break;
            case LayoutType.SECTION_MENU:
                //三个菜单入口
                helper.setText(R.id.tv_1, item.getDataList().get(0).getRname());
                helper.setText(R.id.tv_2, item.getDataList().get(1).getRname());
                helper.setText(R.id.tv_3, item.getDataList().get(2).getRname());
                Glide.with(mContext)
                        .load(item.getDataList().get(0).getPic())
                        .into((ImageView) helper.getView(R.id.iv_1));
                Glide.with(mContext)
                        .load(item.getDataList().get(1).getPic())
                        .into((ImageView) helper.getView(R.id.iv_2));
                Glide.with(mContext)
                        .load(item.getDataList().get(2).getPic())
                        .into((ImageView) helper.getView(R.id.iv_3));

                break;
            default:
                break;
        }
    }

}
