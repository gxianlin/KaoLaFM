package com.ilynn.kaolafm.ui.view;

import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.base.IView;

import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/13 0013 21:15
 * 修改日期: 2017/9/13 0013
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public interface RadioView extends IView{
    /**
     * 轮播图
     * @param bannerList
     */
    void onSuccessBanner(List<Special> bannerList);

    /**
     * 滚动文字
     * @param textList
     */
    void onSuccessMessage(List<Special> textList);

    /**
     * 主播列表
     * @param radioList
     */
    void onSuccessRadio(List<DataListBean<List<RadioHost>>> radioList);
}
