package com.ilynn.kaolafm.ui.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ilynn.base.BaseFragment;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.custom.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 描述：主页面  发现
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class MineFragment extends BaseFragment {

    @InjectView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private List<String> mList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("gxl", "int = " + newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取最后一个可见view的位置
                    int lastItemPosition = linearManager.findLastVisibleItemPosition();
                    //获取第一个可见view的位置
                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    if (newState==RecyclerView.SCROLL_STATE_IDLE){
                        showToast("当前第一个是:"+firstItemPosition);
                    }
                    Log.e("gxl","first = "+firstItemPosition + ", last = " + lastItemPosition);
                }
            }
        });
    }

    @Override
    public void initData() {

        mList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            mList.add("哈哈" + i);
        }

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DemoAdapter mAdapter = new DemoAdapter(getActivity(), R.layout.item_ification_class, mList);
        //        mAdapter.openLoadAnimation();
        mRecyclerView.setAdapter(mAdapter);//设置adapter
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_ification_class, parent, false);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.tvTitle);
            tv.setText(mList.get(position));
            return convertView;
        }
    }

    class DemoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        int mLayoutId;

        public DemoAdapter(Context context, int LayoutId, List<String> str) {
            super(LayoutId, str);
            mLayoutId = LayoutId;
        }

        @Override
        public void convert(BaseViewHolder helper, String str) {
            helper.setText(R.id.tvTitle, str);
        }
    }
}
