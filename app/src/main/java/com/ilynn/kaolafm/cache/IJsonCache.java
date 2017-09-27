package com.ilynn.kaolafm.cache;

import rx.Observable;

/**
 * 描述：缓存json数据接口
 *      采用三级缓存机制:内存,磁盘,网络
 *
 * 作者：gong.xl
 * 创建日期：2017/9/27 下午4:36
 * 修改日期: 2017/9/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface IJsonCache {
    /**
     * 读取缓存
     *
     * @param key 缓存key
     * @param cls 实体类型
     * @return 返回实体数据
     */
    <T extends BaseCache> Observable<T> get(String key, Class<T> cls);


    /**
     * 存储数据到缓存
     *
     * @param key  缓存key
     * @param data 数据
     */
    <T extends BaseCache> void put(String key, T data);
}
