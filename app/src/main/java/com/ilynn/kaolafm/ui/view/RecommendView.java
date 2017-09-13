package com.ilynn.kaolafm.ui.view;

import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.ui.base.IView;

/**
 * 描述：推荐页面  view
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午1:52
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface RecommendView extends IView{
     void onSuccess(Recommend recommend);
}
