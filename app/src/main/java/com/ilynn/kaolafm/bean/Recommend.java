package com.ilynn.kaolafm.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * 描述：推荐页面数据实体
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午11:50
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class Recommend extends BaseResult {

    private List<DataListBean<List<Special>>> dataList;

    public List<DataListBean<List<Special>>> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean<List<Special>>> dataList) {
        this.dataList = dataList;
    }

}
