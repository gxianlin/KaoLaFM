package com.ilynn.kaolafm.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
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

    /***
     * Glide加载图片
     */
    public static void GlideWith(Context context, String coverUrl
            , final ImageView imageView) {

        Glide.with(context)
                .load(coverUrl)
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

    public static void clipGlideWith(Context context, String path, final ImageView imageView) {
        Glide.with(context)
                .load(path)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable drawable, GlideAnimation<? super GlideDrawable>
                            glideAnimation) {
                        //剪裁drawable对象
                        int w = drawable.getIntrinsicWidth();
                        int h = drawable.getIntrinsicHeight();

                        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                : Bitmap.Config.RGB_565;
                        Bitmap bitmap = Bitmap.createBitmap(w, h, config);

                        //注意，下面三行代码要用到，否则在View或者SurfaceView里的canvas.drawBitmap会看不到图
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, w, h);
                        drawable.draw(canvas);

                        Bitmap newBM = Bitmap.createBitmap(bitmap, 0, 180, w, h - 180, null, false);
                        bitmap.recycle();

                        imageView.setImageBitmap(newBM);
                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        imageView.setImageDrawable(errorDrawable);
                    }
                });
    }

    /**
     * 偏移效果
     *
     * @param origin 原图
     * @return 偏移后的bitmap
     */
    private Bitmap skewBitmap(Bitmap origin) {
        if (origin == null) {
            return null;
        }
        int width = origin.getWidth();
        int height = origin.getHeight();
        Matrix matrix = new Matrix();
        matrix.postSkew(-0.6f, -0.3f);
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 180, width, height - 180, matrix, false);
        if (newBM.equals(origin)) {
            return newBM;
        }
        origin.recycle();
        return newBM;
    }


}
