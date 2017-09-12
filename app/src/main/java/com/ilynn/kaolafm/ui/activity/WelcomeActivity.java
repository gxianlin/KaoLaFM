package com.ilynn.kaolafm.ui.activity;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.ui.base.BaseMVPActivity;
import com.ilynn.kaolafm.ui.presenter.BannerPresenter;
import com.ilynn.kaolafm.ui.view.BannerView;
import com.ilynn.kaolafm.utils.ImageUtil;

/**
 * 描述：欢迎页面
 * <p>
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午5:05
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class WelcomeActivity extends BaseMVPActivity<BannerView, BannerPresenter> implements BannerView {

    private ImageView mWelcomeIv;
    private Handler mHandler;
    private Banner mBanner;

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initViews() {
        mWelcomeIv = findView(R.id.imageView);
    }

    @Override
    public void initData() {

        mPresenter.loadBanner();
        //发起请求
        //http://api.kaolafm.com/api/v4/splashscreen/list?timezone=28800&installid=0004AnHA&operator=0&lon=0.0&lat
        // =0.0&network=1&timestamp=1503047319&resolution=800*1280&devicetype=0&channel=A-myapp&version=5.0.2&appid=0&
    }

    @Override
    public void setListener() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startToActivity(MainActivity.class);
                finish();
            }
        }, 2000);
    }

    @Override
    public void showFail(int code, String message) {

    }

    @Override
    public void success(Banner data) {
        mBanner = data;
        LogUtils.e("success");
        ImageUtil.GlideWith(this, data.getImg(), R.drawable.welcome_default, mWelcomeIv);
        mWelcomeIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showToast(mBanner.getAction());
    }
}
