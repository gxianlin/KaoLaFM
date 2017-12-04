package com.ilynn.kaolafm.bean;

import com.ilynn.kaolafm.cache.BaseCache;

/**
 * Created by Administrator on 2017/12/4.
 */

public class TypePageConfig extends BaseCache{
    private TypeTabs typeTabs;
    private TypeId typeId;

    public TypePageConfig(TypeTabs typeTabs, TypeId typeId) {
        this.typeTabs = typeTabs;
        this.typeId = typeId;
    }

    public TypeTabs getTypeTabs() {
        return typeTabs;
    }

    public TypeId getTypeId() {
        return typeId;
    }
}
