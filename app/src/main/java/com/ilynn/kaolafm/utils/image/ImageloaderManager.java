package com.ilynn.kaolafm.utils.image;

import android.view.View;

/**
 * 描述：图片加载管理类
 * 作者：gong.xl
 * 创建日期：2017/9/25 上午10:09
 * 修改日期: 2017/9/25
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class ImageloaderManager implements ImageLoaderStrategy {
    private static final ImageloaderManager INSTANCE = new ImageloaderManager();

    private ImageLoaderStrategy mImageLoader;

    private ImageloaderManager() {
        //默认使用GLide
        mImageLoader = new GlideImageLoader();
    }

    public static ImageloaderManager getInstance() {
        return INSTANCE;
    }

    /**
     * 设置图片加载框架
     * @param imageLoader
     */
    public void setImageLoader(ImageLoaderStrategy imageLoader) {
        if (imageLoader != null) {
            mImageLoader = imageLoader;
        }
    }

    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        mImageLoader.showImage(v,url,options);
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        mImageLoader.showImage(v,drawable,options);
    }
}
