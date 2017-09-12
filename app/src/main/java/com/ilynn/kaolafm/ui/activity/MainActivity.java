package com.ilynn.kaolafm.ui.activity;

import com.google.gson.Gson;
import com.ilynn.base.BaseActivity;
import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;


public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        float[] arr = new float[5];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[0] = 0;
        Gson gson = new Gson();
        String s = gson.toJson(arr);
        float[] floats = gson.fromJson(s, float[].class);
        for (int i = 0; i < floats.length; i++) {
            LogUtils.e(floats[i]);
        }
        LogUtils.e(TAG, s);
    }

    @Override
    public void setListener() {

    }

}
