package com.ilynn.kaolafm.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.TypeMenu;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.activity.TypeListActivity;
import com.ilynn.kaolafm.ui.adapter.TypeOtherMenuAdapter;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.TypOtherPresenter;
import com.ilynn.kaolafm.ui.view.TypeOtherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 描述：分类-其他分类
 * 作者：gong.xl
 * 创建日期：2017/11/24 上午10:28
 * 修改日期: 2017/11/24
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class TypeOtherFragment extends BaseMVPFragment<TypeOtherView, TypOtherPresenter> implements TypeOtherView,
        AdapterView.OnItemClickListener {
    @InjectView(R.id.gridview)
    GridView mGridview;
    private TypeOtherMenuAdapter mMenuAdapter;
    private List<TypeMenu.Types> mMenuList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_type_other;
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
        mMenuAdapter = new TypeOtherMenuAdapter(mContext, mMenuList);
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
    public void typeOtherSuccess(TypeMenu hotType) {
        mMenuList.addAll(hotType.getDataList());
        mMenuAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(mContext, TypeListActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtra(Constants.FID, String.valueOf(mMenuList.get(position).getCategoryId()));
        intent.putExtra(Constants.TITLE, mMenuList.get(position).getTitle());
        startActivity(intent);
    }
}
