package com.ilynn.kaolafm.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.Banner;
import com.ilynn.kaolafm.config.Constants;
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
        //设置欢迎页面全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //无title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
        return R.layout.activity_welcome;
    }

    @Override
    public void initViews() {
        mWelcomeIv = findView(R.id.imageView);
    }

    @Override
    public void initData() {
        //请求页面广告
        mPresenter.loadData(mParams, false);
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
        //延时2.5秒后跳转到主页面
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startToActivity(MainActivity.class);
                finishThis();
            }
        }, 2500);
    }

    @Override
    public void onError(int code, String message) {

    }

    @Override
    public void onSuccess(Banner data) {
        mBanner = data;
        ImageUtil.GlideWith(this, data.getImg(), R.drawable.welcome_default, mWelcomeIv);
        mWelcomeIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String action = mBanner.getAction();
        if (!TextUtils.isEmpty(action)) {
            //取消handler发送消息
            mHandler.removeCallbacksAndMessages(null);
            Intent intent = new Intent(this, WebActivity.class);
            intent.putExtra(Constants.WEN_BANNER,action );
            startActivity(intent);
            finishThis();
        }
    }

    public void finishThis() {
        if (!this.isFinishing()) {
            finish();
        }
    }
}
