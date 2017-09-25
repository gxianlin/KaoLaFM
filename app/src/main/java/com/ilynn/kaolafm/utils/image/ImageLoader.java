package com.ilynn.kaolafm.utils.image;

import android.widget.ImageView;

/**
 * 描述：统一的图片加载器
 * 作者：gong.xl
 * 创建日期：2017/9/25 上午9:49
 * 修改日期: 2017/9/25
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface ImageLoader {
    void showImage(ImageView imageView,String url,ImageLoaderOptions options);

    void showImage(ImageView imageView,int drawable,ImageLoaderOptions options);
}
