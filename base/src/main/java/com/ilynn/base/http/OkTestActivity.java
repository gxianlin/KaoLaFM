package com.ilynn.base.http;

import com.ilynn.base.BaseAvtivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/23 上午10:43
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class OkTestActivity extends BaseAvtivity {
    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        getRequest();
        postRequest();
    }


    @Override
    protected void setListener() {

    }

    public void getRequest() {
        Request request = new Request.Builder().url("https://www.baidu.com").build();

        OkHttpClient client = new OkHttpClient();

        //构建任务
        Call call = client.newCall(request);

        //执行任务
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();

                //onResponse执行在非ui线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //主线程调用
                    }
                });
            }
        });

    }

    private void postRequest() {
        OkHttpClient client = new OkHttpClient();

        //请求体
        FormBody.Builder formBody = new FormBody.Builder();
        //请求参数
        formBody.add("name", "abc");
        formBody.add("pwd", "123");

        //构建请求
        Request request = new Request.Builder()
                .url("https://login.com")
                .post(formBody.build())
                .build();

        //构建任务
        Call call = client.newCall(request);

        //执行任务
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();

                //onResponse执行在非ui线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //主线程调用
                    }
                });
            }
        });
    }

    private void request() {
        CommonOkhttpClient.get(CommonRequest.createGetRequest("url", null), new DisposeHandler(new DisposeListener() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onFailure(Object error) {

            }
        }));


        RequestParams params = new RequestParams();
        params.put("name", "abc");
        params.put("pwd", "123");
        CommonOkhttpClient.post(CommonRequest.createPostRequest("url", params), new DisposeHandler(new DisposeListener() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onFailure(Object error) {

            }
        },Object.class));
    }


}
