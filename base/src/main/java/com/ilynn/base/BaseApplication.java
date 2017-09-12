package com.ilynn.base;

import android.app.Application;
import android.content.Context;
import android.support.v7.appcompat.BuildConfig;

import com.ilynn.base.util.LogUtils;

/**
 * 描述：基础application
 * 作者：gong.xl
 * 创建日期：2017/8/22 下午5:48
 * 修改日期: 2017/8/22
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BaseApplication extends Application {
    private static Context mContext;
    private static BaseApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mContext = this;
        initLog();
    }

    private void initLog() {
        LogUtils.Builder logBuilder = new LogUtils.Builder();
        logBuilder = new LogUtils.Builder()
                .setLogSwitch(BuildConfig.DEBUG)// 设置log总开关，默认开
                .setGlobalTag("kaola")// 设置log全局标签，默认为空
                // 当全局标签不为空时，我们输出的log全部为该tag，
                // 为空时，如果传入的tag为空那就显示类名，否则显示tag
                .setLog2FileSwitch(false)// 打印log时是否存到文件的开关，默认关
                .setBorderSwitch(true)// 输出日志是否带边框开关，默认开
                .setLogFilter(LogUtils.V);// log过滤器，和logcat过滤器同理，默认Verbose
    }

    public static Context getContext() {
        return mContext;
    }

    public static BaseApplication getInstance() {
        return application;
    }
}
