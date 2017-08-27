package com.ilynn.base;

import android.app.Application;

/**
 * 描述：基础application
 * 作者：gong.xl
 * 创建日期：2017/8/22 下午5:48
 * 修改日期: 2017/8/22
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BaseApplication extends Application {
    protected String TAG = BaseApplication.class.getSimpleName();

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static BaseApplication getInstance() {
        return application;
    }
}
