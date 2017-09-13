package com.ilynn.kaolafm.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午4:24
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BroadCastBean extends BaseResult {


    private List<DataListBean> dataList;

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        /**
         * id : 356
         * name : 占位
         * icon :
         * desc :
         * hasmore : 0
         * moreType : 1
         * componentType : 33
         * contentType : 5
         * relatedValue : 0
         * pic :
         * contentSourceId : 1
         * count : 0
         * dataList : []
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

//        @SerializedName("dataList")
        private List<Menu> menus;

        @SerializedName("dataList")
        private List<Special> specials;

//        @SerializedName("dataList")
        private List<RadioHost> radioHosts;

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

        public List<Menu> getMenus() {
            return menus;
        }

        public void setMenus(List<Menu> menus) {
            this.menus = menus;
        }

        public List<Special> getSpecials() {
            return specials;
        }

        public void setSpecials(List<Special> specials) {
            this.specials = specials;
        }

        public List<RadioHost> getRadioHosts() {
            return radioHosts;
        }

        public void setRadioHosts(List<RadioHost> radioHosts) {
            this.radioHosts = radioHosts;
        }

        public static class Menu{

            /**
             * type : 1
             * typeName : 类型
             * dataList : [{"id":1,"name":"国家台","type":1,"pic":"","label":-1}]
             */

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
                /**
                 * id : 1
                 * name : 国家台
                 * type : 1
                 * pic :
                 * label : -1
                 */

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

        public static class Special{

            /**
             * rid : 1100000145879
             * rtype : 0
             * rname : 提供有价值的声音
             * pic : http://img.kaolafm.net/mz/images/201607/6c2c75c9-4260-4984-8224-4db996e010b5/default.jpg
             * weburl :
             * des : 提供有价值的声音
             * albumName : 说给你听
             * albumId : -1
             * num : 0
             * host : []
             * mp3PlayUrl :
             * cornerMark : 0
             * rvalue : 1100000145879
             * tip :
             * followedNum : 0
             * listenNum : 0
             * area : null
             * reportUrl : []
             * expoUrl : []
             * adType : -1
             * adUserId :
             * adId :
             * dataReport : 说给你听
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
            private int albumId;
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

            public int getAlbumId() {
                return albumId;
            }

            public void setAlbumId(int albumId) {
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

        public static class RadioHost{

            /**
             * uid : 2400521
             * nickName : 青音
             * avatar : http://img.kaolafm.net/mz/images/201612/0ba189f3-c470-4633-8124-4c214b3563c5/default.jpg
             * likedNum : 4
             * isVanchor : 0
             * gender : 3
             * liveStatus : 0
             * recommendReson : 资深情感节目主持人
             * extraAttributes :
             * relation : 0
             * fansCount : 1541
             * desc : 欢迎关注微信公众号：青音约 (sweetamily) 每晚8点，打开微信公众号：青音约，可以听到青音姐的“晚安心灵语音”、心理专家的情感问答和滋养心灵的视频、音乐和文字。
             * 点击“订阅专辑”，就能及时收到节目更新推送。
             */

            private int uid;
            private String nickName;
            private String avatar;
            private int likedNum;
            private int isVanchor;
            private int gender;
            private int liveStatus;
            private String recommendReson;
            private String extraAttributes;
            private int relation;
            private int fansCount;
            private String desc;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getLikedNum() {
                return likedNum;
            }

            public void setLikedNum(int likedNum) {
                this.likedNum = likedNum;
            }

            public int getIsVanchor() {
                return isVanchor;
            }

            public void setIsVanchor(int isVanchor) {
                this.isVanchor = isVanchor;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getLiveStatus() {
                return liveStatus;
            }

            public void setLiveStatus(int liveStatus) {
                this.liveStatus = liveStatus;
            }

            public String getRecommendReson() {
                return recommendReson;
            }

            public void setRecommendReson(String recommendReson) {
                this.recommendReson = recommendReson;
            }

            public String getExtraAttributes() {
                return extraAttributes;
            }

            public void setExtraAttributes(String extraAttributes) {
                this.extraAttributes = extraAttributes;
            }

            public int getRelation() {
                return relation;
            }

            public void setRelation(int relation) {
                this.relation = relation;
            }

            public int getFansCount() {
                return fansCount;
            }

            public void setFansCount(int fansCount) {
                this.fansCount = fansCount;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

    }
}
