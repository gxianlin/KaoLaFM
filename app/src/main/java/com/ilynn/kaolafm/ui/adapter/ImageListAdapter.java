package com.ilynn.kaolafm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.utils.ImageUtil;

import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/10/20 下午1:43
 * 修改日期: 2017/10/20
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class ImageListAdapter extends BaseAdapter {
    private List<String> imageUrls;
    private Context mContext;
    private OnDeleteListener mDeleteListener;

    public ImageListAdapter(Context context, List<String> imageUrls) {
        this.imageUrls = imageUrls;
        mContext = context;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return imageUrls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent, false);
            holder.ivDel = (ImageView) convertView.findViewById(R.id.image_del);
            holder.image = (ImageView) convertView.findViewById(R.id.image_show);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDeleteListener != null){
                    mDeleteListener.onDelete(position);
                }
            }
        });
        ImageUtil.GlideWith(mContext, imageUrls.get(position), R.mipmap.ic_launcher, holder.image);
        return convertView;
    }
    public interface OnDeleteListener{
        void onDelete(int position);
    }

    public void setDeleteListener(OnDeleteListener deleteListener) {
        mDeleteListener = deleteListener;
    }

    class ViewHolder {
        ImageView ivDel;
        ImageView image;
    }
}
