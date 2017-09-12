package com.ilynn.kaolafm.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ilynn.base.BaseActivity;

import java.lang.reflect.ParameterizedType;

/**
 * 描述：mvp 模式基础activity
 *
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午5:05
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public abstract class BaseMVPActivity<V extends IView, P extends BasePresenter<V>>
        extends BaseActivity implements IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = getInstance(this);
        mPresenter.attachView((V) this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    /**
     * 通过实例工厂去实例化相应类
     *
     * @param o   带泛型的对象
     * @param <T> 返回实例的泛型类型
     * @return
     */
    public <T> T getInstance(Object o) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[1])
                    .newInstance();
        } catch (InstantiationException | ClassCastException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
