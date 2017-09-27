package com.ilynn.kaolafm.bean;

import java.util.List;

/**
 * 描述：分类页面数据实体
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午2:28
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class TypeMenu extends BaseBean {

    /**
     * name : 热门分类
     * dataList : [{"categoryId":648,"title":"搞笑","titleColor":"","type":5,"parentId":-1,"parentCategoryName":"",
     * "label":-1,"icon":"http://img.kaolafm.net/mz/images/201701/51c4a6a7-7ce7-4312-b08b-f946ff997e40/default.png",
     * "backgroundPic":"","dataList":[{"categoryId":667,"title":"笑话段子","titleColor":"","type":1,"parentId":648,
     * "parentCategoryName":"搞笑","label":-1,"icon":"","backgroundPic":"","dataList":[]}]}]
     */

    private String name;
    private List<Types> dataList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Types> getDataList() {
        return dataList;
    }

    public void setDataList(List<Types> dataList) {
        this.dataList = dataList;
    }

    public static class Types {
        /**
         * categoryId : 648
         * title : 搞笑
         * titleColor :
         * type : 5
         * parentId : -1
         * parentCategoryName :
         * label : -1
         * icon : http://img.kaolafm.net/mz/images/201701/51c4a6a7-7ce7-4312-b08b-f946ff997e40/default.png
         * backgroundPic :
         * dataList : [{"categoryId":667,"title":"笑话段子","titleColor":"","type":1,"parentId":648,
         * "parentCategoryName":"搞笑","label":-1,"icon":"","backgroundPic":"","dataList":[]}]
         */

        private int categoryId;
        private String title;
        private String titleColor;
        private int type;
        private int parentId;
        private String parentCategoryName;
        private int label;
        private String icon;
        private String backgroundPic;
        private List<DataListBean> dataList;

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleColor() {
            return titleColor;
        }

        public void setTitleColor(String titleColor) {
            this.titleColor = titleColor;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getParentCategoryName() {
            return parentCategoryName;
        }

        public void setParentCategoryName(String parentCategoryName) {
            this.parentCategoryName = parentCategoryName;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getBackgroundPic() {
            return backgroundPic;
        }

        public void setBackgroundPic(String backgroundPic) {
            this.backgroundPic = backgroundPic;
        }

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            /**
             * categoryId : 667
             * title : 笑话段子
             * titleColor :
             * type : 1
             * parentId : 648
             * parentCategoryName : 搞笑
             * label : -1
             * icon :
             * backgroundPic :
             * dataList : []
             */

            private int categoryId;
            private String title;
            private String titleColor;
            private int type;
            private int parentId;
            private String parentCategoryName;
            private int label;
            private String icon;
            private String backgroundPic;
            private List<?> dataList;

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitleColor() {
                return titleColor;
            }

            public void setTitleColor(String titleColor) {
                this.titleColor = titleColor;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getParentCategoryName() {
                return parentCategoryName;
            }

            public void setParentCategoryName(String parentCategoryName) {
                this.parentCategoryName = parentCategoryName;
            }

            public int getLabel() {
                return label;
            }

            public void setLabel(int label) {
                this.label = label;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getBackgroundPic() {
                return backgroundPic;
            }

            public void setBackgroundPic(String backgroundPic) {
                this.backgroundPic = backgroundPic;
            }

            public List<?> getDataList() {
                return dataList;
            }

            public void setDataList(List<?> dataList) {
                this.dataList = dataList;
            }
        }
    }
}
