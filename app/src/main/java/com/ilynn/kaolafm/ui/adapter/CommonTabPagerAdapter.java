package com.ilynn.kaolafm.ui.adapter;



import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/25 下午5:36
 * 修改日期: 2017/9/25
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class CommonTabPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT;
    private List<String> list;
    private Context context;
    private TabPagerListener listener;

    public interface TabPagerListener{
        Fragment getFragment(int position);
    }

    public void setListener(TabPagerListener listener) {
        this.listener = listener;
    }

    public CommonTabPagerAdapter(FragmentManager fm, int count, List<String> list, Context context) {
        super(fm);
        if (list==null||list.isEmpty()){
            throw new ExceptionInInitializerError("list can't be null or empty");
        }
        if (count<=0){
            throw new ExceptionInInitializerError("count value error");
        }
        this.PAGE_COUNT = count;
        this.list = list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return listener.getFragment(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

}