package com.ilynn.kaolafm.cache;

import rx.Observable;

/**
 * 描述：1级缓存 网络层
 *
 * 抽象此类,本项目采用mvp模式,网络获取数据的具体实现在model中
 *
 * 作者：gong.xl
 * 创建日期：2017/9/27 下午4:48
 * 修改日期: 2017/9/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class NetCache<T extends BaseCache> {


    /**
     * 获取网络数据
     *
     * @return 返回数据实体
     */
    public abstract Observable<T> get();
}
