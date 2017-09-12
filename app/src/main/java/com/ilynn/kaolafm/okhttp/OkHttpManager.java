package com.ilynn.kaolafm.okhttp;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午3:06
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class OkHttpManager {
    private static OkHttpManager mInstance;
    private OkHttpClient mHttpClient;
    private Handler mHandler;
    private Gson mGson;


    private OkHttpManager(){
        mHandler = new Handler();
        mGson = new Gson();
        initOkhttp();
    }
    public static synchronized OkHttpManager getInstance(){
        if (mInstance == null){
            mInstance = new OkHttpManager();
        }
        return mInstance;
    }

    private void initOkhttp(){

        mHttpClient = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public void request(SimpleHttpClient client, final BaseCallBack callBack){

        if (callBack == null){
            return;
        }


        mHttpClient.newCall(client.buildRequest()).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailure(call,e);
                    }
                });
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        handlerResponse(call,response,callBack);
                    }
                });
            }
        });
    }

    private void handlerResponse(Call call, Response response, BaseCallBack callBack) {
        if (response.isSuccessful()){
            try {
                String result = response.body().string();
                if (callBack.mType == null || callBack.mType == String.class){
                    callBack.onSuccess(result);
                }else {
                    callBack.onSuccess(mGson.fromJson(result,callBack.mType));
                }

            } catch (IOException e) {
                callBack.onError(response.code());
            }
        }else {
            callBack.onFailure(call,null);
        }
    }
}
