package com.ilynn.kaolafm.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.benmei.imageselectorlibrary.MultiImageSelectorActivity;
import com.google.gson.Gson;
import com.ilynn.base.BaseActivity;
import com.ilynn.base.util.SPUtils;
import com.ilynn.kaolafm.R;
import com.ilynn.kaolafm.ui.adapter.ImageListAdapter;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.OnClick;

public class ImageUpLoadActivity extends BaseActivity {

    @InjectView(R.id.gridview)
    GridView mGridview;


    //仅用于页面显示图片,不参与其他逻辑
    ArrayList<String> imageUrls;

    //之前的图片,用于判断是否需要删除网络图片
    ArrayList<String> oldImages;

    //新添加的图片,用于记录是否需要新上传图片
    ArrayList<String> newImage;

    //需要删除的网络图片
    ArrayList<String> deleteImages;

    private ImageListAdapter mImageAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_image_up_load;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        oldImages = new ArrayList<>();
        newImage = new ArrayList<>();
        deleteImages = new ArrayList<>();

        imageUrls = getIntent().getStringArrayListExtra("images");
        oldImages.addAll(imageUrls);

        if (imageUrls == null || imageUrls.size() < 1) {
            showToast("图片网址为空");
        } else {
            showToast("图片数量为:" + imageUrls.size());
        }
        mImageAdapter = new ImageListAdapter(this, imageUrls);
        mImageAdapter.setDeleteListener(new ImageListAdapter.OnDeleteListener() {
            @Override
            public void onDelete(int position) {
                //当点击的索引为之前存在的图片时
                if (position < oldImages.size()) {

                    String removeUrl = oldImages.remove(position);
                    //将需要删除的图片记录到集合
                    deleteImages.add(removeUrl);
                } else {

                    //直接移除
                    newImage.remove(position - oldImages.size());
                }

                //刷新页面显示
                imageUrls.remove(position);
                mImageAdapter.notifyDataSetChanged();
            }
        });
        mGridview.setAdapter(mImageAdapter);
        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast("点击第" + position + "项");
            }
        });
    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.back, R.id.add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                //返回
                disposeImage();
                break;
            case R.id.add:
                //添加图片
                Intent intent = new Intent(this, MultiImageSelectorActivity.class);
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 10);
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);
                //                startActivity(intent);
                startActivityForResult(intent, 1000);
                break;
            default:
                break;
        }
    }

    /**
     * 处理图片
     */
    private void disposeImage() {
        //图片没有发生更改
        if (deleteImages.size() == 0 && newImage.size()==0){
            finish();
        }

        showWaitingDialog();

        upLoadImage();

        //判断是否需要删除图片
        if (deleteImages.size() > 0) {
            showToast("需要删除服务器图片" + deleteImages.size() + "张");
        }
        for (int i = 0; i < deleteImages.size(); i++) {
            Log.e("tag", "删除图片网址:" + deleteImages.get(i));
        }
    }

    /**
     * 等待对话框
     */
    private void showWaitingDialog() {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件完成后，主动调用函数关闭该Dialog
     */
        final ProgressDialog waitingDialog=
                new ProgressDialog(this);
        waitingDialog.setTitle("图片正在处理");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();

        //模拟网络请求
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //图片上传或删除成功
                waitingDialog.dismiss();
                Intent intent = new Intent();
                intent.putStringArrayListExtra("oldImages",oldImages);
                setResult(RESULT_OK,intent);
                finish();
            }
        },2000);
    }
    /**
     * 上传图片
     */
    private void upLoadImage() {
        //如果新添加图片集合有数据,则上传图片
        if (newImage.size() > 0) {
            //上传图片逻辑
            showToast("需要上传图片,上传的图片为第" + (oldImages.size() + 1) + "张到" + (oldImages.size() + newImage.size()) + "张");
        }

        for (int i = 0; i < newImage.size(); i++) {
            Log.e("tag", "上传图片路径:" + newImage.get(i));
        }

        //将图片路径保存到SP
        String upLoadImages = new Gson().toJson(newImage);
        SPUtils.put(this,"upLoadImages",upLoadImages);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {

            ArrayList<String> imagePaths = data.getStringArrayListExtra(MultiImageSelectorActivity
                    .EXTRA_RESULT);

            for (int i = 0; i < imagePaths.size(); i++) {
                newImage.add(imagePaths.get(i));
                imageUrls.add("file://" + imagePaths.get(i));
            }
            mImageAdapter.notifyDataSetChanged();
        }


    }
}
