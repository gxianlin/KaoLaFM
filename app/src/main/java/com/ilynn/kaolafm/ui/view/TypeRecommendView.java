package com.ilynn.kaolafm.ui.view;

import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.ui.base.IView;

/**
 * Created by Administrator on 2017/12/4.
 */

public interface TypeRecommendView extends IView {
    void onRecommendSuccess(Recommend recommend);
}
