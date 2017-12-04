package com.ilynn.kaolafm.ui.fragment;

import android.os.Bundle;

import com.ilynn.base.BaseFragment;
import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.config.Constants;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.TypeRecommendPresenter;
import com.ilynn.kaolafm.ui.view.TypeRecommendView;

/**
 * Created by Administrator on 2017/12/4.
 */

public class TypeRecommendFragment extends BaseMVPFragment<TypeRecommendView, TypeRecommendPresenter> implements TypeRecommendView {


    public static TypeRecommendFragment newInstance(int pageId) {
        TypeRecommendFragment fragment = new TypeRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.PAGE_ID, pageId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_type_recommend;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        mParams.put(Constants.PAGE_ID, bundle.getInt(Constants.PAGE_ID));
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
    public void onRecommendSuccess(Recommend recommend) {
        LogUtils.e(recommend);
    }
}
