package com.ilynn.kaolafm.bean;

import com.ilynn.kaolafm.cache.BaseCache;

/**
 * Created by Administrator on 2017/12/4.
 */

public class TypeId extends BaseCache{

    private int categoryId;
    private String categoryName;
    private int hasSub;
    private String logo;
    private int haveFind;
    private int pageId;
    private int location;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getHasSub() {
        return hasSub;
    }

    public void setHasSub(int hasSub) {
        this.hasSub = hasSub;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getHaveFind() {
        return haveFind;
    }

    public void setHaveFind(int haveFind) {
        this.haveFind = haveFind;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
