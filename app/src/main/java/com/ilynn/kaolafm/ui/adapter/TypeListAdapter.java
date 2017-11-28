package com.ilynn.kaolafm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.TypeList;
import com.ilynn.kaolafm.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/11/27 下午2:59
 * 修改日期: 2017/11/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.ViewHolder> {

    private Context mContext;

    private List<TypeList.DataListBean> mDataList;

    public TypeListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_type_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageUtil.GlideWith(mContext, mDataList.get(position).getPic(), holder.icon);
        holder.title.setText(mDataList.get(position).getName());
        holder.content.setText(mDataList.get(position).getDesc());
    }

    /**
     * 设置数据
     *
     * @param dataList
     */
    public void setDataList(List<TypeList.DataListBean> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     *
     * @param dataLis
     */
    public void addDataList(List<TypeList.DataListBean> dataLis) {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }

        mDataList.addAll(dataLis);
        notifyDataSetChanged();
    }

    /**
     * 清空数据
     */
    public void clearData(){
        mDataList.clear();
    }

    /**
     * 添加数据
     *
     * @param bean
     */
    public void addDataList(TypeList.DataListBean bean) {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        mDataList.add(bean);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView title;
        private TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
