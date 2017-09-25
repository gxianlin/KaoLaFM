package com.ilynn.kaolafm.utils.image;

import android.view.View;

/**
 * 描述：统一的图片加载器
 * 作者：gong.xl
 * 创建日期：2017/9/25 上午9:49
 * 修改日期: 2017/9/25
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface ImageLoaderStrategy {
    /**
     * 根据URL加载图片
     */
    void showImage(View v, String url, ImageLoaderOptions options);

    /**
     * 加载资源图片
     */
    void showImage(View v, int drawable, ImageLoaderOptions options);
}
