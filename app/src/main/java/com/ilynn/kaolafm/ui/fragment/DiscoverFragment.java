package com.ilynn.kaolafm.ui.fragment;

import android.widget.TextView;
import android.widget.Toast;

import com.ilynn.base.BaseFragment;
import com.ilynn.kaolafm.R;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 描述：发现
 * 作者：gong.xl
 * 创建日期：2017/9/15 上午10:47
 * 修改日期: 2017/9/15
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class DiscoverFragment extends BaseFragment {
    @InjectView(R.id.name)
    TextView mName;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {
    }

    @Override
    public void initData() {
        mName.setText("这是发现页面");

    }

    @OnClick(R.id.name)
    public void onViewClicked() {
        Toast.makeText(mContext, "哈哈哈", Toast.LENGTH_SHORT).show();
    }
}
