package com.ilynn.kaolafm.bean;

/**
 * 描述：欢迎页面广告
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 22:40
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class Banner extends BaseResult{

    /**
     * showTime : 3
     * img : http://img.kaolafm.net/mz/images/201709/af6891d9-6d14-44b9-9125-06f1adafbc37/720_1100.jpg
     * actionType : 6
     * action : https://www.fitapp.com.cn/task/108
     * currentTime : null
     * oid : 2959
     */

    private int showTime;
    private String img;
    private int actionType;
    private String action;
    private Object currentTime;
    private int oid;

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Object currentTime) {
        this.currentTime = currentTime;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
}
