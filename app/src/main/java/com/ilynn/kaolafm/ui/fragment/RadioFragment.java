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


        String data = "{\"mark\":\"0\",\"tip\":\"成功\",\"obj\":{\"teacher_avatar_url\":\"http://file.waijiaojun" +
                ".com/waijiaojun/app/image/teacher/3551/head/201706051549151.png\",\"weike_id\":null," +
                "\"images\":[{\"id\":175,\"sort\":1,\"part\":10," +
                "\"url\":\"waijiaojun/weike/content/29/10_1508398100469_d75f3ba5-051c-46b8-b9e0" +
                "-ef78e7d6be02_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":176,\"sort\":2,\"part\":10," +
                "\"url\":\"waijiaojun/weike/content/29/10_1508398204027_4d57a830-1366-4635-80d8" +
                "-9fcf72035f96_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":192,\"sort\":3,\"part\":10," +
                "\"url\":\"waijiaojun/weike/content/29/10_1508415943199_b35f08a0-c0a4-4bbd-8404" +
                "-0c0fdac260f0_dts_featured_quiet_comfort_qc.png\"},{\"id\":193,\"sort\":4,\"part\":10," +
                "\"url\":\"waijiaojun/weike/content/29/10_1508415943246_170657d0-26ee-471b-8eff" +
                "-e5b3fd1aace8_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":194,\"sort\":5,\"part\":10," +
                "\"url\":\"waijiaojun/weike/content/29/10_1508415943263_02f56c83-8a90-4de8-a845" +
                "-097831fba98f_1504756270140.png\"}],\"parts\":[{\"id\":88,\"sort\":1,\"title\":\"title\"," +
                "\"contents\":[{\"id\":238,\"part_sort\":1,\"sort\":1,\"type\":\"text\",\"content\":\"ghj\"," +
                "\"duration\":-1,\"play_number\":null,\"durationFromat\":\"\"},{\"id\":242,\"part_sort\":1," +
                "\"sort\":2,\"type\":\"audio\",\"content\":\"waijiaojun/weike/content/29/org.springframework.web" +
                ".multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile" +
                "@26f0e560_1508328077275_26bc6535-bf42-43af-a022-cbf89f75339d_20171018080115.wav\",\"duration\":2," +
                "\"play_number\":null,\"durationFromat\":\"2″\"}]},{\"id\":89,\"sort\":2,\"title\":\"title\"," +
                "\"contents\":[{\"id\":240,\"part_sort\":2,\"sort\":1,\"type\":\"text\",\"content\":\"ggj\"," +
                "\"duration\":-1,\"play_number\":null,\"durationFromat\":\"\"}]},{\"id\":90,\"sort\":3," +
                "\"title\":\"title\",\"contents\":[{\"id\":241,\"part_sort\":3,\"sort\":1,\"type\":\"text\"," +
                "\"content\":\"yhv\",\"duration\":-1,\"play_number\":null,\"durationFromat\":\"\"}]},{\"id\":91," +
                "\"sort\":4,\"title\":\"title\",\"contents\":[]},{\"id\":92,\"sort\":5,\"title\":\"d\"," +
                "\"contents\":[]},{\"id\":93,\"sort\":6,\"title\":\"chrome\",\"contents\":[]},{\"id\":95,\"sort\":7," +
                "\"title\":\"title\",\"contents\":[{\"id\":243,\"part_sort\":7,\"sort\":1,\"type\":\"audio\"," +
                "\"content\":\"waijiaojun/weike/content/29/org.springframework.web.multipart.support" +
                ".StandardMultipartHttpServletRequest$StandardMultipartFile@2dde7ac2_1508328544513_d9d4abec-abfc-40f5" +
                "-afa7-70a5e017faa5_20171018080902.wav\",\"duration\":3,\"play_number\":null," +
                "\"durationFromat\":\"3″\"}]},{\"id\":96,\"sort\":8,\"title\":\"title\",\"contents\":[{\"id\":248," +
                "\"part_sort\":8,\"sort\":1,\"type\":\"audio\",\"content\":\"waijiaojun/weike/content/29/org" +
                ".springframework.web.multipart.support" +
                ".StandardMultipartHttpServletRequest$StandardMultipartFile@4cf9099c_1508378931885_a50b71df-5811-49fb" +
                "-b7b6-aa71f330b5bb_20171019100850.wav\",\"duration\":3,\"play_number\":null," +
                "\"durationFromat\":\"3″\"}]},{\"id\":97,\"sort\":9,\"title\":\"title\",\"contents\":[]},{\"id\":98," +
                "\"sort\":10,\"title\":\"title\",\"contents\":[{\"id\":250,\"part_sort\":10,\"sort\":1," +
                "\"type\":\"audio\",\"content\":\"waijiaojun/weike/content/29/org.springframework.web.multipart" +
                ".support.StandardMultipartHttpServletRequest$StandardMultipartFile@75b90c57_1508379954196_2b1693b2" +
                "-7375-498b-9930-bf3e2d61a47f_20171019102550.wav\",\"duration\":5,\"play_number\":null," +
                "\"durationFromat\":\"5″\"},{\"id\":251,\"part_sort\":10,\"sort\":2,\"type\":\"audio\"," +
                "\"content\":\"waijiaojun/weike/content/29/org.springframework.web.multipart.support" +
                ".StandardMultipartHttpServletRequest$StandardMultipartFile@43894f1e_1508379994129_9e868cf0-b513-45c4" +
                "-bae2-bc7727fce4cd_20171019102633.wav\",\"duration\":2,\"play_number\":null," +
                "\"durationFromat\":\"2″\"}]}]}}\n";


        String json = "{\"mark\":\"0\",\"tip\":\"成功\",\"obj\":{\"teacher_avatar_url\":\"http://file.waijiaojun" +
                ".com/waijiaojun/app/image/teacher/3551/head/201706051549151.png\",\"weike_id\":null," +
                "\"images\":[{\"id\":177,\"sort\":1,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508398679629_677215c7-2105-4e6f-8110" +
                "-c46dc275fe63_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":178,\"sort\":2,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508399359573_9c943aeb-f678-4186-9143" +
                "-2648b70c46f4_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":179,\"sort\":3,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508409441609_d492772c-868d-4f4b-afc8" +
                "-0c37b2afb753_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":180,\"sort\":4,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508411639309_8e2025f7-6b75-460a-b229" +
                "-a8984ee49a09_1504756269109.png\"},{\"id\":181,\"sort\":5,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508412937336_610afbe9-d53a-495a-8108" +
                "-db1cb72e35d7_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":182,\"sort\":6,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508412947857_89a7d88e-f322-4f1d-8515" +
                "-2b8a552e79ed_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":183,\"sort\":7,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508412967472_e8cec889-1280-4fe3-93cc" +
                "-361a90410dd0_1504756269109.png\"},{\"id\":184,\"sort\":8,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508413028314_319195f9-d897-42a5-a022" +
                "-fb5955da3c75_1504756269109.png\"},{\"id\":185,\"sort\":9,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508413238019_c37d2fbe-39d5-45c5-9977" +
                "-f97d195419e3_dts_featured_quiet_comfort_qc.png\"},{\"id\":186,\"sort\":10,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508414651692_501b3db8-b29b-464d-aac1" +
                "-6664711adede_1504756269109.png\"},{\"id\":187,\"sort\":11,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508414733013_1267e72b-207e-4faa-a586" +
                "-1840afe1fdcb_icon_51AD696350BB47629F3226B29D5AB925.png\"},{\"id\":188,\"sort\":12,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508415038690_16e81564-99a1-4e08-9110" +
                "-743e109d3b9b_1504756269109.png\"},{\"id\":189,\"sort\":13,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508415334753_4d64b7d6-3eef-479d-bdd8" +
                "-bdb0d801b66f_1504756269109.png\"},{\"id\":190,\"sort\":14,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508415365934_9c61c58d-a120-40a9-8f0c" +
                "-e6c4ca82b9a9_1504664250763.png\"},{\"id\":195,\"sort\":15,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508461677276_0f53f876-180a-4f18-aec1" +
                "-6920b5bb6006_1504664250763.png\"},{\"id\":196,\"sort\":16,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508461895629_3ace22f9-edf2-4fe6-8302" +
                "-07a000a683d6_1504756270140.png\"},{\"id\":197,\"sort\":17,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508462015876_4f43d9fc-06d2-4279-9e81" +
                "-b2832a7c5a36_1504756269109.png\"},{\"id\":198,\"sort\":18,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508462079376_0e515e58-53ec-4796-b541" +
                "-220edaaf9411_dts_featured_quiet_comfort_qc.png\"},{\"id\":199,\"sort\":19,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508462145877_56766a86-9671-4468-81f5" +
                "-3b1deebf359d_1504756270140.png\"},{\"id\":200,\"sort\":20,\"part\":3," +
                "\"url\":\"waijiaojun/weike/content/30/3_1508462176150_8e3e031a-9290-4e42-95aa" +
                "-8c72faa98289_1504664250763.png\"}],\"parts\":[{\"id\":100,\"sort\":1,\"title\":\"rty\"," +
                "\"contents\":[]},{\"id\":101,\"sort\":2,\"title\":\"chrome\",\"contents\":[]},{\"id\":104," +
                "\"sort\":3,\"title\":\"hhj\",\"contents\":[]},{\"id\":109,\"sort\":4,\"title\":\"title\"," +
                "\"contents\":[]}]}}\n" +
                "\n" +
                "\n";


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
