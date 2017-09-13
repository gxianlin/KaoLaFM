package com.ilynn.kaolafm.ui.view;

import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.ui.base.IView;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午2:26
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface TypeView extends IView{
    void hotTypeSuccess(TypeMenu hotType);
    void otherTypeSuccess(TypeMenu otherType);
}
