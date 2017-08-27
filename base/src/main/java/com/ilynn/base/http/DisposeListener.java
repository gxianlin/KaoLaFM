package com.ilynn.base.http;

/**
 * 描述：响应回调
 * 作者：gong.xl
 * 创建日期：2017/8/23 下午1:21
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface DisposeListener {

    void onSuccess(Object response);

    void onFailure(Object error);
}
