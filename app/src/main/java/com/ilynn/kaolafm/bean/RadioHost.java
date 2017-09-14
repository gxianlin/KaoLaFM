package com.ilynn.kaolafm.bean;

/**
 * 主播信息 bean
 */
public class RadioHost {
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