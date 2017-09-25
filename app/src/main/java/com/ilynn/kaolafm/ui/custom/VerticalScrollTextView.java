package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.ilynn.kaolafm.bean.Special;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16.
 */
public class VerticalScrollTextView extends View {
    /**
     * 滚动时用于显示的内容
     */
    private String text1, text2,title1,title2;

    /**
     * 绘制内容的起始位置
     */
    private float fromX, fromY;

    /**
     * 暂停时Text1初始Y坐标
     */
    private float startY;

    /**
     * 记录当前滚动的索引
     */
    private int position = -1;

    private Paint paint = new Paint();
    private Paint paint2 = new Paint();

    /**
     * 滚动的数据源
     */
    private List<String> list,list2;

    /**
     * 滚动一次暂停的时间
     */
    private final int delay = 3000;

    /**
     * 滚动一次所花的时间
     */
    private final int scrollTime = 2000;

    /**
     * 控件的宽高
     */
    private int width, height;

    private float speed = 1;

    private IOnClickListener listener;



    public VerticalScrollTextView(Context context) {
        super(context);
    }

    public VerticalScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        list = new ArrayList<>();
        list.add("11111111111111");
        list.add("22222222222222");
        list.add("33333333333333");
        list.add("44444444444444");
        list2 = new ArrayList<>();
        list2.add("中国");
        list2.add("江西");
        list2.add("九江");
        list2.add("修水");

        paint.setTextSize(25);

        post(new Runnable() {
            @Override
            public void run() {
                width = getWidth();
                height = getHeight();
//                speed = 1.0f * height / scrollTime;
                pause();
            }
        });

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onClick(getIndex());
                }
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (text1 == null || text2 == null) {
            return;
        }
        paint2.setColor(Color.RED);
        paint2.setTextSize(25);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);

        RectF rectF1 = new RectF(fromX,fromY-height/2-5,fromX+60,fromY+5);
        RectF rectF2 = new RectF(fromX,fromY+height/2-5,fromX+60,fromY+height+5);

        canvas.drawRoundRect(rectF1,10,10,paint2);
        canvas.drawRoundRect(rectF2,10,10,paint2);

        canvas.drawText(title1,fromX+5,fromY,paint2);
        canvas.drawText(title2,fromX+5,fromY+height,paint2);




        canvas.drawText(text1, fromX+70, fromY, paint);
        canvas.drawText(text2, fromX+70, fromY + height, paint);
//        canvas.drawText(text1, 70, fromY, paint);
//        canvas.drawText(text2, 70, fromY + 70, paint);
    }

    /**
     * 开始滚动
     */
    private void start() {
//        invalidate();

        scroll();
    }

    /**
     * 执行滚动
     */
    private void scroll() {
        fromY -= speed;

        post(new Runnable() {
            @Override
            public void run() {
                invalidate();

                if (needPause())
                {
                    pause();
                }
                else
                {
                    scroll();
                }
            }
        });


    }

    /**
     * 是否要暂停
     *
     * @return
     */
    private boolean needPause() {
        //如果text2的Y坐标小于或等于text1的y坐标的初始值,表示需要暂停
        if (fromY + height <= startY) {
            return true;
        }

        return false;
    }

    /**
     * 暂停
     */
    private void pause() {
        position++;

        int index1 = position % list.size();
        int index2 = (index1 + 1) % list.size();

        text1 = list.get(index1);
        text2 = list.get(index2);

        title1 = list2.get(index1);
        title2 = list2.get(index2);


        float text1Height = getTextHeight(text1);

        startY = height - (height - text1Height)/2;

        fromY = startY;

        postDelayed(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }, delay);
    }

    /**
     * 获取字符串的高度
     * @param text
     * @return
     */
    private float getTextHeight(String text)
    {
        Rect rect = new Rect();

        paint.getTextBounds(text,0,text.length(),rect);

        return rect.height();
    }

    /**
     * 获取字符串的索引
     * @return
     */
    public int getIndex()
    {
        return position % list.size();
    }

    public void setIOnClickListener(IOnClickListener listener)
    {
        this.listener = listener;
    }

    public interface IOnClickListener
    {
        void onClick(int position);
    }


    public void setData(List<Special> anchorChildList){
        list.clear();
        list2.clear();
        for(int i=0;i<anchorChildList.size();i++) {
            list.add(anchorChildList.get(i).getDes());
            list2.add(anchorChildList.get(i).getAlbumName());
        }
    }
}
