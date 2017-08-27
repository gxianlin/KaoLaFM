package com.ilynn.base.http;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 描述：用来发送get post请求类
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午2:02
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class CommonOkhttpClient {
    private static final int TIME_OUT = 30;
    private static OkHttpClient mClient;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //对HTTPS的认证,走过任意主机都允许
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.followRedirects(true);

        //https支持
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        //信任证书
        builder.sslSocketFactory(HttpsUtil.getSslSocketFactory());

        mClient = builder.build();
    }

    public static Call post(Request request,DisposeListener listener,Class<?> clzss){
        Call call = mClient.newCall(request);
        call.enqueue(new CommonJsonCallback(new DisposeHandler(listener,clzss)));
        return call;
    }
    public static Call post(Request request,DisposeListener listener){
        Call call = mClient.newCall(request);
        call.enqueue(new CommonJsonCallback(new DisposeHandler(listener)));
        return call;
    }

    public static Call post(Request request,DisposeHandler handler){
        Call call = mClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handler));
        return call;
    }

    public static Call get(Request request,DisposeListener listener,Class<?> clzss){
        Call call = mClient.newCall(request);
        call.enqueue(new CommonJsonCallback(new DisposeHandler(listener,clzss)));
        return call;
    }
    public static Call get(Request request,DisposeListener listener){
        Call call = mClient.newCall(request);
        call.enqueue(new CommonJsonCallback(new DisposeHandler(listener)));
        return call;
    }
    public static Call get(Request request,DisposeHandler handler){
        Call call = mClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handler));
        return call;
    }


}
