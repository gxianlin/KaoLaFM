package com.ilynn.kaolafm.ui.base;

import com.ilynn.kaolafm.api.RequestParams;

/**
 * 描述：单个请求model
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午1:20
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface BaseModel {
    /**
     * 获取数据
     *
     * @param params      请求参数
     * @param isNeedCache 是否需要取缓存
     */
    void loadData(RequestParams params, boolean isNeedCache);
}
