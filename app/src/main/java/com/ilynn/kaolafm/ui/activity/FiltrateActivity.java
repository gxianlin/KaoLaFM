package com.ilynn.kaolafm.ui.activity;

import android.content.Intent;
import android.view.View;

import com.ilynn.base.BaseActivity;
import com.ilynn.base.util.SPUtils;
import com.ilynn.kaolafm.R;

import butterknife.OnClick;

public class FiltrateActivity extends BaseActivity {
    private String[] name = {"江西", "广东", "浙江", "江苏"};
    private String KEY = "name";

    @Override
    public int getLayoutId() {
        return R.layout.activity_filtrate;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        int index = (int) SPUtils.get(this, KEY, -1);
        if (index != -1) {
            showToast("上次选中的是: " + name[index]);
        }
    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.btn_jx, R.id.btn_gd, R.id.btn_zj, R.id.btn_js})
    public void onViewClicked(View view) {
        int index;
        switch (view.getId()) {
            case R.id.btn_jx:
                index = 0;
                break;
            case R.id.btn_gd:
                index = 1;
                break;
            case R.id.btn_zj:
                index = 2;
                break;
            case R.id.btn_js:
                index = 3;
                break;
            default:
                index = -1;
                break;
        }
        showToast("点击了: " + name[index]);
        SPUtils.put(this, KEY, index);
        Intent intent = new Intent();
        intent.putExtra("index",index);
        setResult(1001,intent);
        finish();
    }
}
