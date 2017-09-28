package com.ilynn.kaolafm.bean;

import com.google.gson.JsonArray;
import com.ilynn.kaolafm.cache.BaseCache;

import java.util.List;

/**
 * 描述：主播页面数据实体
 * 作者：gong.xl
 * 创建日期：2017/9/13 0013 21:19
 * 修改日期: 2017/9/13 0013
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RadioBean extends BaseCache {

    private List<DataListBean<JsonArray>> dataList;

    public List<DataListBean<JsonArray>> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean<JsonArray>> dataList) {
        this.dataList = dataList;
    }
}
