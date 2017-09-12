package com.ilynn.kaolafm.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 描述：处理网络数据处理完成后的回调响应
 *
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午5:05
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RequestParams {
    private Map<String,Object> mMap;

    private String apiKey;

    public Map<String, Object> getMap() {
        return mMap;
    }

    public RequestParams(String apiKey) {
        this.apiKey = apiKey;
        mMap = new HashMap<>();
    }

    public void put(String key,Object values){
        if (mMap != null){
            mMap.put(key,values);
        }
    }

    public Object get(String key){
        if (mMap != null){
            return mMap.get(key);
        }else {
            return null;
        }
    }

    @Override
    public String toString() {
        //重写toString,用于缓存json文件命名
        StringBuffer sb = new StringBuffer();
        sb.append(apiKey + "-");
        Iterator mIterator = null;
        if (!mMap.isEmpty()) {
            mIterator = mMap.entrySet().iterator();
            while (mIterator.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) mIterator.next();
//                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                sb.append("-" + value);
            }
        }
        return sb.toString();
    }
}
