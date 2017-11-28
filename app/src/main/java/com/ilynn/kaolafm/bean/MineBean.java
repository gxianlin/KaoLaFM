package com.ilynn.kaolafm.bean;

import com.ilynn.kaolafm.cache.BaseCache;

import java.lang.reflect.Type;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/28 下午5:31
 * 修改日期: 2017/11/28
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class MineBean extends BaseCache {
    private Banner banner;
    private TypeMenu menu;

    public MineBean(Banner banner, TypeMenu menu) {
        this.banner = banner;
        this.menu = menu;
    }

    public Banner getBanner() {
        return banner;
    }

    public TypeMenu getMenu() {
        return menu;
    }
}
