package com.ilynn.kaolafm.cache;

import com.google.gson.Gson;
import com.ilynn.kaolafm.bean.BaseBean;

import java.util.Calendar;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/27 下午4:42
 * 修改日期: 2017/9/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BaseCache extends BaseBean {
    //记录从网络获取到数据的时间值
    private long mCreateTime;

    public BaseCache() {
        mCreateTime = System.currentTimeMillis();
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    /**
     * 判断缓存是否在到期
     *
     * @return
     */
    public boolean isExpire() {
        //获取当前日期的固定时间(此处早上6点)
        long currTimeMills = getCurrentDayToMills();

        //获取系统当前时间
        long time = System.currentTimeMillis();

        if (mCreateTime > currTimeMills) {
            return (mCreateTime - currTimeMills) > SAME_TIME;
        } else {
            if ((currTimeMills - mCreateTime) > MAX_TIME) {
                return true;
            } else {
                if (time < currTimeMills) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    public long getCurrentDayToMills() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, FIXED_TIME);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    //固定时间点,用于判断缓存是否过期(此处早上6点)
    private final int FIXED_TIME = 6;
    private final long MAX_TIME = 24 * 3600 * 1000;
    private final long SAME_TIME = (24 - FIXED_TIME) * 3600 * 1000;
}
