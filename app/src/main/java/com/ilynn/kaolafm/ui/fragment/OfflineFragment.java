package com.ilynn.kaolafm.ui.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ilynn.base.BaseFragment;
import com.ilynn.base.util.DensityUtil;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.custom.WordFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

import static com.ilynn.base.util.DensityUtil.dp2px;

/**
 * 描述：主页面  发现
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class OfflineFragment extends BaseFragment {

    @InjectView(R.id.word_2)
    WordFlowLayout mWord2;

    //用于记录上次点击的索引
    int lastIndex = -1;
    //存放所有TextView
    List<TextView> mTextViews = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_offline;
    }

    @Override
    public void initViews() {


        //数据源
        List<String> list = new ArrayList<>();
        list.add("中秋月饼");
        list.add("中秋月饼");
        list.add("中秋月饼");
        list.add("中秋月饼");
        list.add("中秋月饼");
        list.add("中秋月饼");
        list.add("中秋月饼");
        list.add("中秋月饼");
        list.add("中秋月饼");

        //获取屏幕宽度
        int screenWidth = DensityUtil.getScreenWidth(mContext);

        //计算除了间隙剩余的宽度,除以4则是每个TextView的宽度()
        int width = (screenWidth - dp2px(40)) / 4;

        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        //设置边距为5dp
        int margin = DensityUtil.dp2px(5);
        params.leftMargin = margin;
        params.rightMargin = margin;
        params.topMargin = margin;
        params.bottomMargin = margin;

        for (int i = 0, j = list.size(); i < j; i++) {
            TextView tv = new TextView(mContext);
            tv.setText(list.get(i));
            tv.setTextColor(Color.BLACK);
            //设置tag,用于区分点击事件
            tv.setTag(i);
            tv.setGravity(Gravity.CENTER);
            tv.setOnClickListener(this);
            tv.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_textview));

            //添加到集合
            mTextViews.add(tv);

            mWord2.addView(tv, params);
        }
    }

    @Override
    public void onClick(View v) {
        //获取被点击的索引
        int position = (int) v.getTag();

        //获取被点击的TextView
        TextView tv = mTextViews.get(position);

        //改变TextView的字体颜色和背景
        tv.setTextColor(getResources().getColor(R.color.head_bg));
        tv.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_textview_sel));

        //判断是否是第一次点击
        if (lastIndex>=0) {
            //取出上一次点击的TextView
            TextView lastTv = mTextViews.get(lastIndex);
            //恢复默认字体颜色和背景
            lastTv.setTextColor(Color.BLACK);
            lastTv.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_textview));
        }

        //改变上次点击的索引
        lastIndex = position;

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {

    }


}
