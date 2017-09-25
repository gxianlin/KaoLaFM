package com.ilynn.kaolafm.ui.activity;

import android.content.Intent;

import com.ilynn.base.BaseActivity;
import com.ilynn.kaolafm.R;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/15 下午3:25
 * 修改日期: 2017/9/15
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class PlayActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {


        //跳转
        Intent intent = new Intent(this,MainActivity.class);
        //假设 携带一个int型参数
        intent.putExtra("tag",2);
        startActivity(intent);

    }

    @Override
    public void setListener() {

    }
}
