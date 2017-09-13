package com.ilynn.kaolafm.ui.fragment;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.Recommend;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.RecommendPresenter;
import com.ilynn.kaolafm.ui.view.RecommendView;

/**
 * 描述：发现-推荐页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhih.cn
 */
public class RecommendFragment extends BaseMVPFragment<RecommendView,RecommendPresenter> implements RecommendView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_offline;
    }

    @Override
    public void initViews() {

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

    }
}
