package com.ilynn.kaolafm;

import com.ilynn.base.BaseApplication;
import com.umeng.analytics.MobclickAgent;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 23:01
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class KaoLaApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initUMeng();
    }


    /**
     * 初始化友盟统计
     */
    private void initUMeng(){
        MobclickAgent.setDebugMode(true);
        MobclickAgent.openActivityDurationTrack(false);
    }
}
