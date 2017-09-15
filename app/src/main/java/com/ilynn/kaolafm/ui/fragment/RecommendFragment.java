package com.ilynn.kaolafm.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.config.LayoutType;
import com.ilynn.kaolafm.ui.adapter.RecommendAdapter;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.RecommendPresenter;
import com.ilynn.kaolafm.ui.view.RecommendView;

import java.util.List;

import butterknife.InjectView;

/**
 * 描述：发现-推荐页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhih.cn
 */
public class RecommendFragment extends BaseMVPFragment<RecommendView, RecommendPresenter> implements RecommendView {

    @InjectView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initViews() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        mPresenter.loadData();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(int code, String message) {

    }

    @Override
    public void onSuccess(Recommend recommend) {
        List<DataListBean<List<Special>>> dataList = recommend.getDataList();
        //筛选数据
        for (int i = dataList.size() - 1; i >= 0; i--) {
            int type = dataList.get(i).getItemType();
            if (type != LayoutType.BANNER && type != LayoutType.ENTRY && type != LayoutType.SECTION_MENU &&
                    type != LayoutType.SECTION_SQUARE && type != LayoutType.SECTION_VERTICAL) {
                dataList.remove(i);
            }
        }
        RecommendAdapter adapter = new RecommendAdapter(dataList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                showToast("onClick" + position);
            }
        });
        mRecyclerview.setAdapter(adapter);
    }


}
