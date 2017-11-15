package com.ilynn.kaolafm.ui.activity;

import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ilynn.base.BaseActivity;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.config.Constants;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 描述：web页面
 * 作者：gong.xl
 * 创建日期：2017/11/15 下午2:31
 * 修改日期: 2017/11/15
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class WebActivity extends BaseActivity {
    @InjectView(R.id.webview)
    WebView mWebview;

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        String url = getIntent().getStringExtra(Constants.WEN_BANNER);
        //声明WebSettings子类
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setUseWideViewPort(true);

        webSettings.setLoadWithOverviewMode(true);

        mWebview.loadUrl(url);

        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void setListener() {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        startToActivity(MainActivity.class);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebview.canGoBack()) {
            mWebview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
