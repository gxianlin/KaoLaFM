package com.ilynn.kaolafm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.utils.ImageUtil;

import java.util.List;

/**
 * 描述：分类  其他分类菜单
 * 作者：gong.xl
 * 创建日期：2017/11/24 上午11:52
 * 修改日期: 2017/11/24
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class TypeOtherMenuAdapter extends BaseAdapter {

    private Context mContext;
    List<TypeMenu.Types> dataList;

    public TypeOtherMenuAdapter(Context context) {
        this.mContext = context;
    }

    public TypeOtherMenuAdapter(Context context, List<TypeMenu.Types> dataList) {

        this.mContext = context;
        this.dataList = dataList;
    }

    public void setDataList(List<TypeMenu.Types> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList == null ? null : dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_type, parent, false);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ImageUtil.GlideWith(mContext, dataList.get(position).getIcon(), holder.icon);
        holder.name.setText(dataList.get(position).getTitle());

        return convertView;
    }

    class ViewHolder {
        ImageView icon;
        TextView name;
    }
}