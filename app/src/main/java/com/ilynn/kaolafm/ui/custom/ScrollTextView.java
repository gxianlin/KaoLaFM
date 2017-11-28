package com.ilynn.kaolafm.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ilynn.base.util.DensityUtil;
import com.ilynn.kaolafm.R;

import java.util.List;

/**
 * 描述：垂直滚动的text
 * 作者：gong.xl
 * 创建日期：2017/11/21 下午2:57
 * 修改日期: 2017/11/21
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class ScrollTextView extends View {

    public static final float SPEED_LEVEL_1 = 1;
    public static final float SPEED_LEVEL_2 = 2;
    public static final float SPEED_LEVEL_3 = 3;

    /**标题颜色(左边字体)*/
    private int mTitleTextColor;

    /**内容字体颜色(右边字体)*/
    private int mContentTextColor;

    /**字体大小*/
    private int mTextSize;

    /**滚动一次文字停留(暂停)的时间*/
    private int mPauseTime = 2000;

    /**左边标题数据源*/
    private List<String> mTitleList;

    /**右边内容数据源*/
    private List<String> mContentList;

    /**当前的标题*/
    private String mCurrentTitle;
    /**当前内容*/
    private String mCurrentContent;
    /**下一个标题*/
    private String mNextTitle;

    /**下一个内容*/
    private String mNextContent;

    /**控件的宽*/
    private int mWidth;

    /**控件的高*/
    private int mHeight;

    /**绘制内容的起始位置X*/
    private float fromX;

    /**绘制内容的起始位置Y*/
    private float fromY;

    /**暂停时初始Y坐标*/
    private float startY;

    /**矩形框内文字左右边距*/
    private int mTextPadding;

    /** 每次滚动的距离*/
    private float mSpeed;

    /**当前显示的标题和内容是数据源中的第几条*/
    private int mPosition = -1;


    /**标题画笔*/
    private Paint mTitlePaint;

    /**内容画笔*/
    private Paint mContentPaint;

    /**边距*/
    private float margin;
    /**是否已经开始滚动*/
    private boolean isStart;


    /**点击监听事件*/
    private OnTextClickListener mTextClickListener;


    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义属性
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ScrollTextView, 0, 0);

        mTitleTextColor = typedArray.getColor(R.styleable.ScrollTextView_scrollTitleTextColor, context.getResources()
                .getColor(R.color
                        .head_bg));
        mContentTextColor = typedArray.getColor(R.styleable.ScrollTextView_scrollContentTextColor, context
                .getResources().getColor(R.color.text_color_1));

        mTextSize = typedArray.getDimensionPixelSize(R.styleable.ScrollTextView_scrollTextSize, 25);

        mTextPadding = DensityUtil.dp2px(5);
        mSpeed = SPEED_LEVEL_2;

        //初始化画笔
        mTitlePaint = new Paint();
        mTitlePaint.setColor(mTitleTextColor);
        mTitlePaint.setTextSize(mTextSize);
        mTitlePaint.setAntiAlias(true);
        mTitlePaint.setStyle(Paint.Style.STROKE);

        mContentPaint = new Paint();
        mContentPaint.setColor(mContentTextColor);
        mContentPaint.setTextSize(mTextSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        margin = mHeight / 6;
        fromX = margin;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurrentTitle == null || mNextTitle == null) {
            return;
        }

        //创建两个圆角矩形框
        //当前矩形框
        RectF currentRF = new RectF(fromX, fromY - mHeight + 2 * fromX, fromX + getTextWidth(mCurrentTitle) +
                mTextPadding * 2, fromY);

        //下一个矩形框
        RectF nextRF = new RectF(fromX, fromY + 2 * fromX, fromX + getTextWidth(mNextTitle) + mTextPadding * 2, fromY +
                mHeight);

        //绘制两个矩形框
        canvas.drawRoundRect(currentRF, 10, 10, mTitlePaint);
        canvas.drawRoundRect(nextRF, 10, 10, mTitlePaint);

        //绘制矩形框里面文字(标题)
        canvas.drawText(mCurrentTitle, fromX + mTextPadding, fromY - 2 * fromX + getTextHeight(mCurrentTitle) / 3,
                mTitlePaint);
        canvas.drawText(mNextTitle, fromX + mTextPadding, fromY - 2 * fromX + getTextHeight(mCurrentTitle) / 3 +
                mHeight, mTitlePaint);

        //计算剩余可用文本内容宽度
        float currentSurplusWidth = mWidth - currentRF.width() - 3 * fromX;
        float nextSurplusWidth = mWidth - nextRF.width() - 3 * fromX;

        //获取两个内容文字宽度
        float currentTextWidth = getTextWidth(mCurrentContent);
        float nextTextWidth = getTextWidth(mNextContent);

        //如果剩余可用宽度不足以绘制文字内容,则按比例截取文字,并在末尾增加"..."
        float currentPercentage = currentSurplusWidth / currentTextWidth;
        if (currentPercentage < 1) {
            int currentCount = (int) (mCurrentContent.length() * currentPercentage);
            mCurrentContent = mCurrentContent.substring(0, currentCount - 1) + "...";
        }

        float nextPercentage = nextSurplusWidth / nextTextWidth;
        if (nextPercentage < 1) {
            int nextCount = (int) (mNextContent.length() * nextPercentage);
            mNextContent = mNextContent.substring(0, nextCount - 1) + "...";
        }

        //绘制当前内容文字
        canvas.drawText(mCurrentContent, fromX * 2 + currentRF.width(), fromY - 2 * fromX + getTextHeight
                (mCurrentTitle) / 3, mContentPaint);

        //绘制下一条文字内容
        canvas.drawText(mNextContent, fromX * 2 + nextRF.width(), fromY - 2 * fromX + getTextHeight(mCurrentTitle) / 3 +
                mHeight, mContentPaint);

    }

    /**
     * 执行滚动
     */
    private void scroll() {

        //每次滚动距离
        fromY -= mSpeed;
        post(new Runnable() {
            @Override
            public void run() {
                invalidate();

                if (needPause()) {
                    pause();
                } else {
                    scroll();
                }
            }
        });
    }


    /**
     * 开始执行滚动
     */
    private void startScroll() {
        if (!isStart) {
            post(new Runnable() {
                @Override
                public void run() {
                    pause();
                    isStart = true;
                }
            });
        }
    }

    /**
     * 是否需要暂停
     *
     * @return
     */
    private boolean needPause() {

        if (fromY + mHeight <= startY) {
            return true;
        }
        return false;
    }

    /**
     * 暂停滚动
     */
    private void pause() {

        mPosition++;
        int currentIndex = mPosition % mTitleList.size();
        int nextIndex = (currentIndex + 1) % mTitleList.size();


        mCurrentTitle = mTitleList.get(currentIndex);
        mCurrentContent = mContentList.get(currentIndex);

        mNextTitle = mTitleList.get(nextIndex);
        mNextContent = mContentList.get(nextIndex);

        float currentTextHeight = getTextHeight(mCurrentContent);

        startY = mHeight - fromX;

        fromY = startY;

        //暂停一段时间后再次滚动
        postDelayed(new Runnable() {
            @Override
            public void run() {
                scroll();
            }
        }, mPauseTime);
    }


    /**
     * 获取文本的高度
     *
     * @param text 文本内容
     * @return 文本高度
     */
    private float getTextHeight(String text) {
        Rect rect = new Rect();

        mTitlePaint.getTextBounds(text, 0, text.length(), rect);
        return rect.height();
    }

    /**
     * 获取文本宽度
     *
     * @param text
     * @return
     */
    private int getTextWidth(String text) {
        Rect rect = new Rect();

        mTitlePaint.getTextBounds(text, 0, text.length(), rect);
        return rect.width();
    }


    /**
     * 设置数据,并执行滚动
     *
     * @param title
     * @param content
     */
    public void setData(List<String> title, List<String> content) {
        if (title.size() != content.size()) {
            return;
        }
        this.mTitleList = title;
        this.mContentList = content;
        //开始执行滚动
        startScroll();

        //设置点击监听
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTextClickListener != null) {
                    mTextClickListener.onTextClick(getPosition());
                }
            }
        });
    }

    /**
     * 设置滚动速度
     *
     * @param level 速度等级
     */
    public void setSpeedLevel(float level) {
        mSpeed = level;
    }

    /**
     * 获取当前索引
     *
     * @return 当前点击的索引
     */
    private int getPosition() {
        return mPosition % mContentList.size();
    }


    public interface OnTextClickListener {
        void onTextClick(int position);
    }

    /**
     * 设置滚动文字点击监听
     *
     * @param textClickListener
     */
    public void setTextClickListener(OnTextClickListener textClickListener) {
        mTextClickListener = textClickListener;
    }
}
