package com.ilynn.kaolafm.ui.view;

import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.ui.base.IView;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/28 下午5:02
 * 修改日期: 2017/11/28
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface MineView extends IView {

    void onMenuSuccess(TypeMenu menu);

    void onBannerSuccess(Banner banner);
}
