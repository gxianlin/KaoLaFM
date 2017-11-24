package com.ilynn.kaolafm.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.ilynn.base.util.DensityUtil;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.Special;

import java.util.List;

/**
 * 描述：推荐页面 猜一猜适配器
 * 作者：gong.xl
 * 创建日期：2017/9/18 下午3:46
 * 修改日期: 2017/9/18
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class GuessAdapter extends BaseAdapter {
    private List<Special> mSpecials;
    private Context mContext;

    public GuessAdapter(Context context, List<Special> specials) {
        mSpecials = specials;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mSpecials == null ? 0 : mSpecials.size();
    }

    @Override
    public Object getItem(int position) {
        return mSpecials.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_vertical, parent, false);
            holder = new ViewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.imageciew);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.info = (TextView) convertView.findViewById(R.id.info);
            holder.keyWord = (LinearLayout) convertView.findViewById(R.id.keyword);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext)
                .load(mSpecials.get(position).getPic())
                .into(holder.iv);
        holder.title.setText(mSpecials.get(position).getRname());
        holder.info.setText(mSpecials.get(position).getDes());
        List<String> reportUrl = mSpecials.get(position).getReportUrl();
        holder.keyWord.removeAllViews();
        for (String s : reportUrl) {
            TextView tv = new TextView(mContext);
            tv.setText(s);
            tv.setBackgroundResource(R.drawable.text_green_bg);
            tv.setTextSize(10f);
            holder.keyWord.addView(tv);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tv.getLayoutParams();
            layoutParams.setMargins(0, 0, DensityUtil.dp2px(10), 0);
            tv.setLayoutParams(layoutParams);
        }
        return convertView;
    }

    private class ViewHolder {
        ImageView iv;
        TextView title;
        TextView info;
        LinearLayout keyWord;

    }

    private static class MyTransformation extends BitmapTransformation {

        public MyTransformation(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            Bitmap result = pool.get(outWidth, outHeight, Bitmap.Config.ARGB_8888);
            Drawable drawable = new BitmapDrawable(result);
            drawable.setColorFilter(0xFF666666, PorterDuff.Mode.MULTIPLY);

            return drawableToBitmap(drawable);
        }

        @Override
        public String getId() {
            // Return some id that uniquely identifies your transformation.
            return "com.ilynn.kaolafm.ui.adapter.GuessAdapter.MyTransformation";
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {

        Bitmap bitmap = Bitmap.createBitmap(

                drawable.getIntrinsicWidth(),

                drawable.getIntrinsicHeight(),

                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888

                        : Bitmap.Config.RGB_565);

        Canvas canvas = new Canvas(bitmap);

        //canvas.setBitmap(bitmap);

        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

        drawable.draw(canvas);

        return bitmap;

    }
}
