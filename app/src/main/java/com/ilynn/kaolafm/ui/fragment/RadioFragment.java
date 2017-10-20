package com.ilynn.kaolafm.ui.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ilynn.base.util.SPUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.activity.ImageUpLoadActivity;
import com.ilynn.kaolafm.ui.base.BaseMVPFragment;
import com.ilynn.kaolafm.ui.presenter.RadioPresenter;
import com.ilynn.kaolafm.ui.view.RadioView;
import com.ilynn.kaolafm.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static com.ilynn.kaolafm.R.id.viewpager;

/**
 * 描述：发现-主播页面
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午10:47
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RadioFragment extends BaseMVPFragment<RadioView, RadioPresenter> implements RadioView,
        SwipeRefreshLayout.OnRefreshListener {


    @InjectView(viewpager)
    ViewPager mViewpager;

    @InjectView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    ArrayList<String> imageList = new ArrayList<>();
    @InjectView(R.id.tablayout)
    TabLayout mTablayout;
    private MyAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_radio;
    }

    @Override
    public void initViews() {
    }

    @Override
    public void setListener() {
    }

    @Override
    public void initData() {
        //添加一些假数据
        imageList.add("http://img.kaolafm.net/mz/images/201704/64dca3a5-b934-4cd2-95eb-f5fd3cac3735/default.jpg");
        imageList.add("http://img.kaolafm.net/mz/images/201710/5b434fe0-188b-4814-b4ed-ef73ba60b2fd/default.jpg");
        imageList.add("http://img.kaolafm.net/mz/images/201710/a5c6f545-7547-4ff5-aa44-4e82fe8859cf/default.jpg");
        imageList.add("http://img.kaolafm.net/mz/images/201710/3bae492a-f1d6-49fe-991d-74f8f5782356/default.jpg");
        mAdapter = new MyAdapter();
        mViewpager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewpager);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(int code, String message) {

    }


    @Override
    public void onSuccessBanner(List<Special> bannerList) {

    }

    @Override
    public void onSuccessMessage(List<Special> textList) {
    }

    @Override
    public void onSuccessRadio(List<DataListBean<List<RadioHost>>> radioList) {

    }

    @Override
    public void onRefresh() {
        //        mPresenter.loadData(mParams, false);
    }

    @OnClick(R.id.add_image)
    public void onViewClicked() {
        Intent intent = new Intent(mContext, ImageUpLoadActivity.class);
        intent.putStringArrayListExtra("images", imageList);
        startActivityForResult(intent, 123);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {

            //以下处理都为模拟此页面刷新数据更新数据源

            ArrayList<String> oldImages = data.getStringArrayListExtra("oldImages");
            imageList.clear();
            imageList.addAll(oldImages);
            //如果之前有上传才回调
            String upLoadImages = (String) SPUtils.get(mContext, "upLoadImages", "");
            ArrayList<String> images = new Gson().fromJson(upLoadImages, new TypeToken<ArrayList<String>>() {
            }.getType());
            for (int i = 0; i < images.size(); i++) {
                imageList.add("file://" + images.get(i));
            }

            mAdapter = new MyAdapter();
            mViewpager.setAdapter(mAdapter);
        }

        //        //定义一个存放图片地址的集合
        //        ArrayList<String> imageUrls = new ArrayList<>();
        //
        //        //取出图片数据结合
        //        List<ImageBean> imageBeen = bean.getImages();
        //
        //        //遍历集合,取出对应part的图片地址
        //        for (int i = 0; i < imageBeen.size(); i++) {
        //            //假设我点击的是第三个part
        //            if (imageBeen.get(i).getPart() == 2){
        //                //添加到集合
        //                imageUrls.add(imageBeen.get(i).getUrl());
        //            }
        //        }

    }

    class MyAdapter extends PagerAdapter {
        List<ImageView> mImageViews;

        public MyAdapter() {
            mImageViews = new ArrayList<>();
            for (int i = 0, j = imageList.size(); i < j; i++) {
                ImageView iv = new ImageView(mContext);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                ImageUtil.GlideWith(mContext, imageList.get(i), R.mipmap.ic_launcher, iv);
                mImageViews.add(iv);
            }
        }

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mImageViews.get(position));
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(mImageViews.get(position));
            return mImageViews.get(position);
        }
    }
}
