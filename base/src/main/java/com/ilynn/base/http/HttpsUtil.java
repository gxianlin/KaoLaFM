package com.ilynn.base.http;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/24 下午4:01
 * 修改日期: 2017/8/24
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class HttpsUtil {

    /**
     * 信任所有证书包括自定义证书
     * @return
     */
    public static SSLSocketFactory getSslSocketFactory(){
        //1.创建一个信任管理器类
        X509TrustManager manager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        //2.创建加密上下文
        SSLContext sslContext = null;

        try {
            //参数与服务器保持一致的算法类型
            sslContext = sslContext.getInstance("SSL");

            X509TrustManager[] x509TrustManagers = new X509TrustManager[]{manager};
            sslContext.init(null,x509TrustManagers,new SecureRandom());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return sslContext.getSocketFactory();
    }

}
