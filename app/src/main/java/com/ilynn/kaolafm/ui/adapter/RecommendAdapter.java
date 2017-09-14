package com.ilynn.kaolafm.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.config.LayoutType;

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
//        addItemType(LayoutType.BANNER, R.layout.layout_header_bannder);
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
                break;
            case LayoutType.ENTRY:
                //快捷入口
                break;
            case LayoutType.SECTION_SQUARE:
                //栏目
                helper.setText(R.id.title, item.getName());
                break;
            case LayoutType.SECTION_VERTICAL:
                //猜你喜欢
                break;
            case LayoutType.SECTION_MENU:
                //三个菜单入口
                break;
            default:
                break;
        }
    }

}
