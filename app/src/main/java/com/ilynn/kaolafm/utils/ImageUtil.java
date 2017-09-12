package com.ilynn.kaolafm.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/12 0012 23:18
 * 修改日期: 2017/9/12 0012
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class ImageUtil {

    /***
     * Glide加载图片
     */
    public static void GlideWith(Context context, String coverUrl
            , @NonNull int resID, final ImageView imageView) {

        Glide.with(context)
                .load(coverUrl)
                .placeholder(resID)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable>
                            glideAnimation) {
                        imageView.setImageDrawable(resource);
                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        imageView.setImageDrawable(errorDrawable);
                    }
                });

    }
}
