package com.ilynn.kaolafm.cache;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.KaoLaApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import rx.Observable;
import rx.Subscriber;

/**
 * 描述：3级 磁盘缓存
 * 作者：gong.xl
 * 创建日期：2017/9/27 下午5:05
 * 修改日期: 2017/9/27
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class DiskCache implements IJsonCache {
    private static String TAG = "cache";
    private String CACHE_PATH;

    public DiskCache() {

        //此处使用应用目录下文件缓存路径,可根据需要更改次路径
        CACHE_PATH = KaoLaApplication.getContext().getFilesDir().getAbsolutePath() + "/";
    }

    @Override
    public <T extends BaseCache> Observable<T> get(final String key, final Class<T> cls) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                LogUtils.i(TAG, "从磁盘读取缓存数据,key = " + key);
                if (key.equals("")) {
                    subscriber.onNext(null);
                } else {
                    String filename = CACHE_PATH + key;
                    String result = readDataFromFile(filename);

                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    if (TextUtils.isEmpty(result)) {
                        subscriber.onNext(null);
                    } else {
                        T t = new Gson().fromJson(result, cls);
                        subscriber.onNext(t);
                    }
                }
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public <T extends BaseCache> void put(final String key, final T data) {
        Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {

                LogUtils.i(TAG, "缓存数据到磁盘,key = " + key);

                //文件路径
                String filename = CACHE_PATH + key;

                //数据内容
                String result = data.toString();

                saveText2Disk(filename, result);

                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                }
            }
        });
    }


    /**
     * 读取指定路径文件内容
     *
     * @param fileName 文件绝对路径
     * @return
     */
    private String readDataFromFile(String fileName) {

        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int availableLength = fileInputStream.available();
            byte[] buffer = new byte[availableLength];
            fileInputStream.read(buffer);
            fileInputStream.close();

            return new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将数据以文件形式保存到指定目录
     *
     * @param fileName 保存的文件绝对路径
     * @param text     文件内容数据
     * @return 是否成功保存
     */
    public boolean saveText2Disk(String fileName, String text) {

        File file = new File(fileName);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(text);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            file.delete();
            return false;
        }
        return true;
    }
}
