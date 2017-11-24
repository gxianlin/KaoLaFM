package com.ilynn.kaolafm.bean;

import com.google.gson.annotations.SerializedName;
import com.ilynn.kaolafm.cache.BaseCache;

import java.util.List;

/**
 * 描述：分类详情列表
 * 作者：gong.xl
 * 创建日期：2017/11/23 下午5:33
 * 修改日期: 2017/11/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class TypeList extends BaseCache {
    private int haveNext;
    private int nextPage;
    private int havePre;
    private int prePage;
    private int currentPage;
    private int totalPages;
    private int totalCounts;
    private int pageSize;
    private List<DataListBean> dataList;
    private List<FacetBean> facet;

    public int getHaveNext() {
        return haveNext;
    }

    public void setHaveNext(int haveNext) {
        this.haveNext = haveNext;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getHavePre() {
        return havePre;
    }

    public void setHavePre(int havePre) {
        this.havePre = havePre;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public List<FacetBean> getFacet() {
        return facet;
    }

    public void setFacet(List<FacetBean> facet) {
        this.facet = facet;
    }

    public static class DataListBean {
        private long id;
        private int type;
        private String name;
        private String comeFrom;
        private int comeFromId;
        private String pic;
        private int followedNum;
        private int isOnline;
        private int listenNum;
        private int hasCopyright;
        private String desc;
        private String albumName;
        private int hot;
        private String utime;
        private int adType;
        private String rvalue;
        private String label;
        private Object product;
        private List<HostBean> host;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getComeFrom() {
            return comeFrom;
        }

        public void setComeFrom(String comeFrom) {
            this.comeFrom = comeFrom;
        }

        public int getComeFromId() {
            return comeFromId;
        }

        public void setComeFromId(int comeFromId) {
            this.comeFromId = comeFromId;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getFollowedNum() {
            return followedNum;
        }

        public void setFollowedNum(int followedNum) {
            this.followedNum = followedNum;
        }

        public int getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(int isOnline) {
            this.isOnline = isOnline;
        }

        public int getListenNum() {
            return listenNum;
        }

        public void setListenNum(int listenNum) {
            this.listenNum = listenNum;
        }

        public int getHasCopyright() {
            return hasCopyright;
        }

        public void setHasCopyright(int hasCopyright) {
            this.hasCopyright = hasCopyright;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAlbumName() {
            return albumName;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public String getUtime() {
            return utime;
        }

        public void setUtime(String utime) {
            this.utime = utime;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public String getRvalue() {
            return rvalue;
        }

        public void setRvalue(String rvalue) {
            this.rvalue = rvalue;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Object getProduct() {
            return product;
        }

        public void setProduct(Object product) {
            this.product = product;
        }

        public List<HostBean> getHost() {
            return host;
        }

        public void setHost(List<HostBean> host) {
            this.host = host;
        }

        public static class HostBean {
            /**
             * name : 小蝶
             * des : 著名的搞笑创意配音团队--胥渡吧主创，开创了搞笑配音之风潮，以原创配音金庸、琼瑶经典剧为网友所熟知并拥有了超高的人气和粉丝。
             * img : http://img.kaolafm.net/mz/images/201312/7aae4fb3-0b9b-41b9-90d1-697ed0e53a47/default.jpg
             */

            private String name;
            private String des;
            private String img;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }

    public static class FacetBean {
        /**
         * facetFiled : type
         * facetCountMap : {"20000":6172,"30000":0,"40000":0,"50000":0,"60000":0}
         */

        private String facetFiled;
        private FacetCountMapBean facetCountMap;

        public String getFacetFiled() {
            return facetFiled;
        }

        public void setFacetFiled(String facetFiled) {
            this.facetFiled = facetFiled;
        }

        public FacetCountMapBean getFacetCountMap() {
            return facetCountMap;
        }

        public void setFacetCountMap(FacetCountMapBean facetCountMap) {
            this.facetCountMap = facetCountMap;
        }

        public static class FacetCountMapBean {
            /**
             * 20000 : 6172
             * 30000 : 0
             * 40000 : 0
             * 50000 : 0
             * 60000 : 0
             */

            @SerializedName("20000")
            private int _$20000;
            @SerializedName("30000")
            private int _$30000;
            @SerializedName("40000")
            private int _$40000;
            @SerializedName("50000")
            private int _$50000;
            @SerializedName("60000")
            private int _$60000;

            public int get_$20000() {
                return _$20000;
            }

            public void set_$20000(int _$20000) {
                this._$20000 = _$20000;
            }

            public int get_$30000() {
                return _$30000;
            }

            public void set_$30000(int _$30000) {
                this._$30000 = _$30000;
            }

            public int get_$40000() {
                return _$40000;
            }

            public void set_$40000(int _$40000) {
                this._$40000 = _$40000;
            }

            public int get_$50000() {
                return _$50000;
            }

            public void set_$50000(int _$50000) {
                this._$50000 = _$50000;
            }

            public int get_$60000() {
                return _$60000;
            }

            public void set_$60000(int _$60000) {
                this._$60000 = _$60000;
            }
        }
    }
}
