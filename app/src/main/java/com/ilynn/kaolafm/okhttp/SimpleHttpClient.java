package com.ilynn.kaolafm.okhttp;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午2:43
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class SimpleHttpClient {
    private Builder mBuilder;

    private SimpleHttpClient(Builder builder) {
        mBuilder = builder;
    }

    public void enqueue(BaseCallBack callBack) {
        OkHttpManager.getInstance().request(this,callBack);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Request buildRequest() {
        Request.Builder builder = new Request.Builder();
        if (mBuilder.method.equals("GE")) {
            builder.get();
            builder.url(buildGetRequestparam());
        } else if (mBuilder.method.equals("POST")) {
            builder.post(buildRequestBody()).url(mBuilder.mUrl);
        }

        return builder.build();
    }

    private RequestBody buildRequestBody() {
        if (mBuilder.isJsonParam) {
            JSONObject jsonObject = new JSONObject();
            for (RequestParam p : mBuilder.mParams) {
                try {
                    jsonObject.put(p.getKey(), p.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            String json = jsonObject.toString();

            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        }

        FormBody.Builder builder = new FormBody.Builder();
        for (RequestParam p : mBuilder.mParams) {
            builder.add(p.getKey(), p.getValue() == null ? "" : p.getValue().toString());
        }
        return builder.build();
    }


    private String buildGetRequestparam() {
        if (mBuilder.mParams.size() <= 0) {
            return mBuilder.mUrl;
        }

        Uri.Builder builder = Uri.parse(mBuilder.mUrl).buildUpon();
        for (RequestParam p : mBuilder.mParams) {
            builder.appendQueryParameter(p.getKey(), p.getValue() == null ? "" : p.getValue().toString());
        }
        String url = builder.build().toString();
        return url;
    }

    public static class Builder {
        private String mUrl;
        private String method;
        private boolean isJsonParam;
        private List<RequestParam> mParams;

        public Builder() {
            method = "GET";
        }

        public Builder url(String url) {
            this.mUrl = url;
            return this;
        }

        public Builder get() {
            method = "GET";
            return this;
        }

        public Builder post() {
            method = "POST";
            return this;
        }

        public Builder json() {

            return this;
        }

        public Builder addParam(String key, Object value) {
            if (mParams == null) {
                mParams = new ArrayList<>();
            }
            mParams.add(new RequestParam(key, value));
            return this;
        }

        public SimpleHttpClient build() {
            return new SimpleHttpClient(this);
        }
    }
}
