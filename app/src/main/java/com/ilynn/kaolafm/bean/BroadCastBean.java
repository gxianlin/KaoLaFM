package com.ilynn.kaolafm.bean;

import com.google.gson.JsonArray;
import com.ilynn.kaolafm.cache.BaseCache;

import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午4:24
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BroadCastBean extends BaseCache {


    private List<DataListBean<JsonArray>> dataList;

    public List<DataListBean<JsonArray>> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean<JsonArray>> dataList) {
        this.dataList = dataList;
    }

    public static class Menu {

        private int type;
        private String typeName;
        private List<RadioType> dataList;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public List<RadioType> getDataList() {
            return dataList;
        }

        public void setDataList(List<RadioType> dataList) {
            this.dataList = dataList;
        }

        public static class RadioType {
            private int id;
            private String name;
            private int type;
            private String pic;
            private int label;

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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getLabel() {
                return label;
            }

            public void setLabel(int label) {
                this.label = label;
            }
        }
    }
}
