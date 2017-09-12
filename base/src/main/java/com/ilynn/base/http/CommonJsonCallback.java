package com.ilynn.base.http;

import android.os.Handler;
import android.os.Looper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 描述：json类型回调
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午1:47
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class CommonJsonCallback implements Callback {
    protected final String REQUEST_CODE = "ecode";
    protected final String ERROR_MSG = "emsg";
    protected final String EMPTY_MSG = "";
    protected final int REQUEST_CODE_VALUE = 0;

    protected final int NETWORK_ERROR = -1;
    protected final int JSON_ERROR = 2;
    protected final int OUT_TIME_ERROR = -2;
    protected final int OTHER_ERROR = -3;

    private DisposeListener mListener;
    private Class<?> mClass;
    private Handler mHandler;
    public CommonJsonCallback(DisposeHandler handler){
        mListener = handler.mListener;
        mClass = handler.mClass;
        mHandler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void onFailure(Call call, final IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(e);
            }
        });
    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        final String result = response.body().string();

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                handlerResponse(result);
            }
        });
    }

    /**
     * 处理请求结果
     * @param result
     */
    private void handlerResponse(String result) {
        if (result == null || result.equals("")){
            mListener.onFailure(new OkHttpException(NETWORK_ERROR,EMPTY_MSG));
            return;
        }
        try {
            JSONObject resultObj = new JSONObject(result);
            if (resultObj.has(REQUEST_CODE)){
                if (mClass == null){
                    mListener.onSuccess(resultObj);
                }else {
                    //GSON 解析

                    //解析完再次判空处理

                    //
                }
            }
        } catch (JSONException e) {
            mListener.onFailure(new OkHttpException(OTHER_ERROR,e.getMessage()));
        }

    }
}
