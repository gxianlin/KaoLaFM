package com.ilynn.kaolafm.bean;

public class DataListBean<T> {
        private int id;
        private String name;
        private String icon;
        private String desc;
        private int hasmore;
        private int moreType;
        private int componentType;
        private int contentType;
        private String relatedValue;
        private String pic;
        private int contentSourceId;
        private int count;
        private T dataList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getHasmore() {
            return hasmore;
        }

        public void setHasmore(int hasmore) {
            this.hasmore = hasmore;
        }

        public int getMoreType() {
            return moreType;
        }

        public void setMoreType(int moreType) {
            this.moreType = moreType;
        }

        public int getComponentType() {
            return componentType;
        }

        public void setComponentType(int componentType) {
            this.componentType = componentType;
        }

        public int getContentType() {
            return contentType;
        }

        public void setContentType(int contentType) {
            this.contentType = contentType;
        }

        public String getRelatedValue() {
            return relatedValue;
        }

        public void setRelatedValue(String relatedValue) {
            this.relatedValue = relatedValue;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getContentSourceId() {
            return contentSourceId;
        }

        public void setContentSourceId(int contentSourceId) {
            this.contentSourceId = contentSourceId;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public T getDataList() {
            return dataList;
        }

        public void setDataList(T dataList) {
            this.dataList = dataList;
        }

    }