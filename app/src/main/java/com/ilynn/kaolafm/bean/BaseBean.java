package com.ilynn.kaolafm.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午1:32
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BaseBean implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
