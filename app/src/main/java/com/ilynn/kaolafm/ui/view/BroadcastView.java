package com.ilynn.kaolafm.ui.view;

import com.ilynn.kaolafm.bean.BroadCastBean;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.base.IView;

import java.util.List;

/**
 * 描述：广播页面 view
 *      考虑到返回json数据类型有三种,分发成三个回调
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午4:53
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface BroadcastView extends IView{

    /**
     * 广播菜单
     * @param menus
     */
    void onSuccessMenu(List<BroadCastBean.Menu> menus);

    /**
     * 栏目
     * @param specials
     */
    void onSuccessHot(List<DataListBean<List<Special>>> specials);

    /**
     * 推荐主播
     * @param radioList
     */
    void onSuccessRadioHost(List<DataListBean<List<RadioHost>>> radioList);

}
