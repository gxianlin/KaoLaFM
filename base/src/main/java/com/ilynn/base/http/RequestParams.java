package com.ilynn.base.http;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午1:26
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class RequestParams {
    public ConcurrentHashMap<String,String> urlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String,Object> fileParams = new ConcurrentHashMap<>();

    public RequestParams(){
        this((Map<String,String>) null);
    }

    public RequestParams(Map<String,String> source){
        if (source != null){
            for (Map.Entry<String,String> entry : source.entrySet()){
                put(entry.getKey(),entry.getValue());
            }
        }
    }

    public void put(String key, String value) {
        if (key != null && value != null){
            urlParams.put(key, value);
        }
    }

    public void put(String key,Object object) throws FileNotFoundException{
        if (key != null){
            fileParams.put(key, object);
        }
    }

    public boolean hasParams(){
        if (urlParams .size()>0||fileParams.size()>0){
            return true;
        }
        return false;
    }
}
