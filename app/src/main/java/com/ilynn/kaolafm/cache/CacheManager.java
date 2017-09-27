package com.ilynn.kaolafm.cache;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 描述：缓存管理类
 * 作者：gong.xl
 * 创建日期：2017/9/27 下午5:21
 * 修改日期: 2017/9/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class CacheManager {

    public static CacheManager sInstance;

    public IJsonCache mMemoryCache;

    private IJsonCache mDiskCache;

    private CacheManager() {
        mDiskCache = new DiskCache();
        mMemoryCache = new MemoryCache();
    }

    /**
     * 获取CacheManager单例
     *
     * @return
     */
    public static CacheManager getInstance() {
        if (sInstance == null) {
            synchronized (CacheManager.class) {
                if (sInstance == null)
                    sInstance = new CacheManager();
            }
        }
        return sInstance;
    }

    /**
     * 加载数据
     * <p>
     * 加载顺序:
     * 1.优先从内存中读取
     * 2.内存中无此条数据时,从磁盘获取
     * 3.磁盘无此条数据时,从网络加载
     *
     * @param key         缓存key
     * @param cls         数据实体类型
     * @param isNeedCache 是否可以取缓存
     * @param netCache    网络数据获取
     * @return 数据
     */
    public <T extends BaseCache> Observable<T> loadData(String key, Class<T> cls,
                                                        boolean isNeedCache, NetCache<T> netCache) {
        return Observable.concat(
                loadFromMemory(key, cls, isNeedCache),
                loadFromDisk(key, cls, isNeedCache),
                loadFromNet(key, netCache)
        ).first(new Func1<T, Boolean>() {
            @Override
            public Boolean call(T t) {

                //此处用于逻辑判断,可用于判断缓存是否存在,是否过期(需自行实现)


                return t != null;
            }
        });

    }


    /**
     * 1.从内存读取数据
     *
     * @param key         缓存key
     * @param cls         数据类型
     * @param isNeedCache 是否可以拿缓存
     * @return 数据
     */
    private <T extends BaseCache> Observable<T> loadFromMemory(String key, Class<T> cls,
                                                               boolean isNeedCache) {
        //当可以取缓存时
        if (isNeedCache) {
            return mMemoryCache.get(key, cls);
        } else {
            //当不允许读缓存,这里返回一个空数据的Observable对象
            return mMemoryCache.get("", cls);
        }

    }


    /**
     * 2.从磁盘获取缓存数据
     * <p>
     * 考虑到有时候需要刷新页面数据,此时则不可取缓存数据,需要从网络获取最新数据
     * 通过 isNeedCache参数判断是否取缓存
     *
     * @param key         缓存key
     * @param cls         数据实体类型
     * @param isNeedCache 是否需要取缓存
     * @return 数据
     */
    private <T extends BaseCache> Observable<T> loadFromDisk(final String key, Class<T> cls, boolean isNeedCache) {
        //当可以取缓存时
        if (isNeedCache) {
            return mDiskCache.get(key, cls).doOnNext(new Action1<T>() {
                @Override
                public void call(T t) {
                    if (t != null) {
                        //当从磁盘获取到数据时,将数据缓存至内存
                        //既然已经从磁盘获取数据了,说明内存中该条数据已经被GC回收了
                        mMemoryCache.put(key, t);
                    }
                }
            });
        } else {
            //当不允许读缓存,这里返回一个空数据的Observable对象
            return mDiskCache.get("", cls);
        }
    }


    /**
     * 3.从网络获取数据
     *
     * @param key      缓存key
     * @param netCache 网络数据获取
     * @return 获取到的数据
     */
    private <T extends BaseCache> Observable<T> loadFromNet(final String key, NetCache<T> netCache) {
        return netCache.get().doOnNext(new Action1<T>() {
            @Override
            public void call(T t) {
                //如果网络获取到数据,则缓存至内存及磁盘
                if (t != null) {
                    mMemoryCache.put(key, t);
                    mDiskCache.put(key, t);
                }
            }
        });
    }
}
