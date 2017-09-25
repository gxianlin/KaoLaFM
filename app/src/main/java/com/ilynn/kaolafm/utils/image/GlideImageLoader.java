package com.ilynn.kaolafm.utils.image;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

/**
 * 描述：Glide
 * 作者：gong.xl
 * 创建日期：2017/9/25 上午10:03
 * 修改日期: 2017/9/25
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class GlideImageLoader implements ImageLoaderStrategy {
    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            DrawableTypeRequest dtr = Glide.with(imageView.getContext()).load(url);
            loadOptions(dtr,options).into(imageView);
        }
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        if (v instanceof ImageView){
            ImageView imageView = (ImageView) v;
            DrawableTypeRequest dtr = Glide.with(imageView.getContext()).load(drawable);
            loadOptions(dtr,options).into(imageView);
        }
    }


    private DrawableTypeRequest loadOptions(DrawableTypeRequest dtr, ImageLoaderOptions options) {
        if (options == null){
            return dtr;
        }


        return dtr;
    }
}
