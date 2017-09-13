package com.ilynn.kaolafm.bean;

import java.util.List;

/**
 * 描述：推荐页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午11:50
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class Recommend extends BaseResult{

    private List<DataListBeanX> dataList;

    public List<DataListBeanX> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBeanX> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBeanX {
        /**
         * id : 238
         * name : 顶部banner
         * icon :
         * desc :
         * hasmore : 0
         * moreType : 1
         * componentType : 1
         * contentType : 1
         * relatedValue : 0
         * pic :
         * contentSourceId : 6
         * count : 0
         * dataList : [{"rid":1000011064244,"rtype":1,"rname":"世间所有的内向都是聊错了对象","pic":"http://img.kaolafm
         * .net/mz/images/201709/10eda8eb-86e7-4f14-b40a-152c06cca9d2/default.jpg","weburl":"",
         * "des":"今天跟你聊聊\u201c性格\u201d，听听我说的故事，在留言区留下你的想法吧。","albumName":"每天陪你醒来","albumId":1100000474538,"num":0,
         * "host":[],"mp3PlayUrl":"","cornerMark":0,"rvalue":"1000011064244","tip":"","followedNum":0,"listenNum":0,
         * "area":null,"reportUrl":[],"expoUrl":[],"adType":-1,"adUserId":"","adId":"","dataReport":"世间所有的内向都是聊错了对象",
         * "dataList":[],"isSubscribe":0,"callback":null}]
         */

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
        private List<DataListBean> dataList;

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

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            /**
             * rid : 1000011064244
             * rtype : 1
             * rname : 世间所有的内向都是聊错了对象
             * pic : http://img.kaolafm.net/mz/images/201709/10eda8eb-86e7-4f14-b40a-152c06cca9d2/default.jpg
             * weburl :
             * des : 今天跟你聊聊“性格”，听听我说的故事，在留言区留下你的想法吧。
             * albumName : 每天陪你醒来
             * albumId : 1100000474538
             * num : 0
             * host : []
             * mp3PlayUrl :
             * cornerMark : 0
             * rvalue : 1000011064244
             * tip :
             * followedNum : 0
             * listenNum : 0
             * area : null
             * reportUrl : []
             * expoUrl : []
             * adType : -1
             * adUserId :
             * adId :
             * dataReport : 世间所有的内向都是聊错了对象
             * dataList : []
             * isSubscribe : 0
             * callback : null
             */

            private long rid;
            private int rtype;
            private String rname;
            private String pic;
            private String weburl;
            private String des;
            private String albumName;
            private long albumId;
            private int num;
            private String mp3PlayUrl;
            private int cornerMark;
            private String rvalue;
            private String tip;
            private int followedNum;
            private int listenNum;
            private Object area;
            private int adType;
            private String adUserId;
            private String adId;
            private String dataReport;
            private int isSubscribe;
            private Object callback;
            private List<?> host;
            private List<?> reportUrl;
            private List<?> expoUrl;
            private List<?> dataList;

            public long getRid() {
                return rid;
            }

            public void setRid(long rid) {
                this.rid = rid;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public String getRname() {
                return rname;
            }

            public void setRname(String rname) {
                this.rname = rname;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getAlbumName() {
                return albumName;
            }

            public void setAlbumName(String albumName) {
                this.albumName = albumName;
            }

            public long getAlbumId() {
                return albumId;
            }

            public void setAlbumId(long albumId) {
                this.albumId = albumId;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getMp3PlayUrl() {
                return mp3PlayUrl;
            }

            public void setMp3PlayUrl(String mp3PlayUrl) {
                this.mp3PlayUrl = mp3PlayUrl;
            }

            public int getCornerMark() {
                return cornerMark;
            }

            public void setCornerMark(int cornerMark) {
                this.cornerMark = cornerMark;
            }

            public String getRvalue() {
                return rvalue;
            }

            public void setRvalue(String rvalue) {
                this.rvalue = rvalue;
            }

            public String getTip() {
                return tip;
            }

            public void setTip(String tip) {
                this.tip = tip;
            }

            public int getFollowedNum() {
                return followedNum;
            }

            public void setFollowedNum(int followedNum) {
                this.followedNum = followedNum;
            }

            public int getListenNum() {
                return listenNum;
            }

            public void setListenNum(int listenNum) {
                this.listenNum = listenNum;
            }

            public Object getArea() {
                return area;
            }

            public void setArea(Object area) {
                this.area = area;
            }

            public int getAdType() {
                return adType;
            }

            public void setAdType(int adType) {
                this.adType = adType;
            }

            public String getAdUserId() {
                return adUserId;
            }

            public void setAdUserId(String adUserId) {
                this.adUserId = adUserId;
            }

            public String getAdId() {
                return adId;
            }

            public void setAdId(String adId) {
                this.adId = adId;
            }

            public String getDataReport() {
                return dataReport;
            }

            public void setDataReport(String dataReport) {
                this.dataReport = dataReport;
            }

            public int getIsSubscribe() {
                return isSubscribe;
            }

            public void setIsSubscribe(int isSubscribe) {
                this.isSubscribe = isSubscribe;
            }

            public Object getCallback() {
                return callback;
            }

            public void setCallback(Object callback) {
                this.callback = callback;
            }

            public List<?> getHost() {
                return host;
            }

            public void setHost(List<?> host) {
                this.host = host;
            }

            public List<?> getReportUrl() {
                return reportUrl;
            }

            public void setReportUrl(List<?> reportUrl) {
                this.reportUrl = reportUrl;
            }

            public List<?> getExpoUrl() {
                return expoUrl;
            }

            public void setExpoUrl(List<?> expoUrl) {
                this.expoUrl = expoUrl;
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
