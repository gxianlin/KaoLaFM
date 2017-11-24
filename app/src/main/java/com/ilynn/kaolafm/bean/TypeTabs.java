package com.ilynn.kaolafm.bean;

import com.ilynn.kaolafm.cache.BaseCache;

import java.util.List;

/**
 * 描述：分类详情tab菜单
 * 作者：gong.xl
 * 创建日期：2017/11/23 下午5:58
 * 修改日期: 2017/11/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class TypeTabs extends BaseCache {


    private List<DataListBean> dataList;

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        private int categoryId;
        private String categoryName;
        private int hasSub;
        private String logo;
        private int linkType;
        private long id;
        private String imageAoyo;
        private String imageAoyoEffect;

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

        public int getLinkType() {
            return linkType;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getImageAoyo() {
            return imageAoyo;
        }

        public void setImageAoyo(String imageAoyo) {
            this.imageAoyo = imageAoyo;
        }

        public String getImageAoyoEffect() {
            return imageAoyoEffect;
        }

        public void setImageAoyoEffect(String imageAoyoEffect) {
            this.imageAoyoEffect = imageAoyoEffect;
        }
    }
}
