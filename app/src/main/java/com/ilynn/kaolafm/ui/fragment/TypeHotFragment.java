package com.ilynn.kaolafm.ui.fragment;


import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.ui.adapter.TypeOtherMenuAdapter;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.TypeHotPresenter;
import com.ilynn.kaolafm.ui.view.TypeHotView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 描述：分类-热门分类
 * 作者：gong.xl
 * 创建日期：2017/11/24 上午10:28
 * 修改日期: 2017/11/24
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class TypeHotFragment extends BaseMVPFragment<TypeHotView, TypeHotPresenter> implements TypeHotView,
        AdapterView.OnItemClickListener {
    @InjectView(R.id.gridview)
    GridView mGridview;
    private TypeOtherMenuAdapter mMenuAdapter;
    private List<TypeMenu.Types> mMenuList;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_type_hot;
    }

    @Override
    public void initViews() {
    }

    @Override
    public void setListener() {
        mGridview.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        mMenuList = new ArrayList<>();
        mMenuAdapter = new TypeOtherMenuAdapter(mContext,mMenuList);
        mGridview.setAdapter(mMenuAdapter);
        mPresenter.loadData(mParams, true);
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
    public void typeHotSuccess(TypeMenu hotType) {
        //修改数据源数据,刷新界面
        mMenuList.addAll(hotType.getDataList());
        mMenuAdapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int categoryId = mMenuList.get(position).getCategoryId();

    }
}
