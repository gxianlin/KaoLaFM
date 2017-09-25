package com.ilynn.kaolafm.utils.image;

import com.bumptech.glide.request.animation.ViewPropertyAnimation;

/**
 * 描述：设置相关属性类
 * 作者：gong.xl
 * 创建日期：2017/9/25 上午9:50
 * 修改日期: 2017/9/25
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class ImageLoaderOptions {
    //Glide 的设置项
    private int placeHolder = -1;                               //加载中图片
    private ImageReSize mSize = null;                           //重新设定容器宽高
    private int errorDrawable = -1;                             //加载错误图片
    private boolean isCrossFade = false;                        //是否渐变平滑的显示图片
    private boolean isSkipMemoryCache = false;                  //是否跳过内存缓存
    private ViewPropertyAnimation.Animator mAnimator = null;    //图片加载动画


    //Fresco的设置项





    //Picasso的设置项




    public class ImageReSize{
        int reWidth = 0;
        int reHegith = 0;

        public ImageReSize(int reWidth, int reHegith) {
            this.reWidth = reWidth;
            this.reHegith = reHegith;
        }
    }

}
