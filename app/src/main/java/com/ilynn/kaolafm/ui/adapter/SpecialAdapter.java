package com.ilynn.kaolafm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.Special;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/18 下午1:57
 * 修改日期: 2017/9/18
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class SpecialAdapter extends BaseAdapter {
    private List<Special> mSpecials;
    private Context mContext;

    public SpecialAdapter(Context context, List<Special> specials) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_specil, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.specil_iv);
            holder.title = (TextView) convertView.findViewById(R.id.specil_title);
            holder.type = (TextView) convertView.findViewById(R.id.specil_type);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext)
                .load(mSpecials.get(position).getPic())
                .bitmapTransform(new RoundedCornersTransformation(mContext, 20, 0, RoundedCornersTransformation
                        .CornerType.ALL))
                .into(holder.image);
        holder.title.setText(mSpecials.get(position).getRname());
        holder.type.setText(mSpecials.get(position).getAlbumName());

        return convertView;
    }

    private class ViewHolder {
        ImageView image;
        TextView title;
        TextView type;
    }
}
