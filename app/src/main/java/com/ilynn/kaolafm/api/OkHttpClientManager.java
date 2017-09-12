package com.ilynn.kaolafm.api;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * OkHttpClient设置
 *
 * @author gong.xl
 * @version 1.0.0
 * @date 2017/9/12  21:58
 * @copyright wonhigh.cn
 */
public class OkHttpClientManager {
    private static final String TAG = "OkHttpClientManager";

    private static final int DEFAULT_TIMEOUT = 20; //请求超时时间

    /**
     * 创建HttpClient
     *
     * @return
     */
    public static OkHttpClient getClinet(final Context context) {
        //创建OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //设置超时时间
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //创建log拦截器
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        // 拦截 信息 并打印出来
                        Log.i(TAG, "log: " + message);
                    }

                });
        loggingInterceptor.setLevel(level);

        //创建拦截器，为每个请求添加请求头
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                //添加请求头
                Request request;
                request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        };

        builder.addInterceptor(loggingInterceptor);     //添加log输出拦截器
        builder.addInterceptor(interceptor);            //添加请求拦截器
        OkHttpClient client = builder.build();
        setHttpClient(client);
        return client;
    }

    /**
     * 忽略证书校验
     *
     * @param client OkHttpClient
     */

    private static void setHttpClient(OkHttpClient client) {
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
                        throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
                        throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };
        String workerClassName = "okhttp3.OkHttpClient";
        try {
            Class workerClass = Class.forName(workerClassName);
            Field hostnameVerifier = workerClass.getDeclaredField("hostnameVerifier");
            hostnameVerifier.setAccessible(true);
            hostnameVerifier.set(client, hv);

            Field sslSocketFactory = workerClass.getDeclaredField("sslSocketFactory");
            sslSocketFactory.setAccessible(true);
            sslSocketFactory.set(client, sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
