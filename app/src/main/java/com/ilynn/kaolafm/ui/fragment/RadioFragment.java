package com.ilynn.kaolafm.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.custom.ScrollTextView;
import com.ilynn.kaolafm.ui.presenter.RadioPresenter;
import com.ilynn.kaolafm.ui.view.RadioView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 描述：发现-主播页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RadioFragment extends BaseMVPFragment<RadioView, RadioPresenter> implements RadioView,
        SwipeRefreshLayout.OnRefreshListener, ScrollTextView.OnTextClickListener {

    @InjectView(R.id.banner)
    Banner mBanner;

    @InjectView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    ArrayList<String> imageList = new ArrayList<>();

    @InjectView(R.id.roll_tv)
    ScrollTextView mRollTv;
    @InjectView(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    private List<Special> mTextList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_radio;
    }

    @Override
    public void initViews() {
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new com.ilynn.kaolafm.utils.GlideImageLoader(false));

        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.CubeIn);

        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);

    }

    @Override
    public void setListener() {
        mRefresh.setOnRefreshListener(this);

        mRollTv.setTextClickListener(this);
    }

    @Override
    public void initData() {
        mPresenter.loadData(mParams, true);
    }


    @Override
    public void showProgress() {
        mRefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mRefresh.setRefreshing(false);
    }

    @Override
    public void onError(int code, String message) {
    }


    @Override
    public void onSuccessBanner(List<Special> bannerList) {

        ArrayList<String> titles = new ArrayList<>();
        imageList.clear();
        for (Special s : bannerList) {
            imageList.add(s.getPic());
            titles.add(s.getDes());
        }
        //设置图片集合
        mBanner.setImages(imageList);

        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(titles);

        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void onSuccessMessage(List<Special> textList) {
        this.mTextList = textList;
        List<String> title = new ArrayList<>();
        List<String> content = new ArrayList<>();
        for (Special special : textList) {
            title.add(special.getRname());
            content.add(special.getDes());
        }
        mRollTv.setData(title, content);
        mRollTv.setSpeedLevel(ScrollTextView.SPEED_LEVEL_3);
    }

    @Override
    public void onSuccessRadio(List<DataListBean<List<RadioHost>>> radioList) {

    }

    @Override
    public void onTextClick(int position) {
        Toast.makeText(mContext, mTextList.get(position).getDes(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        mPresenter.loadData(mParams, false);
    }
}
