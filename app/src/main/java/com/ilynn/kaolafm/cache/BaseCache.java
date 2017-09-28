package com.ilynn.kaolafm.cache;

import com.google.gson.Gson;
import com.ilynn.kaolafm.bean.BaseBean;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/27 下午4:42
 * 修改日期: 2017/9/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BaseCache extends BaseBean {
    public String toString() {
        return new Gson().toJson(this);
    }
}
