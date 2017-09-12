package com.ilynn.kaolafm.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ilynn.base.BaseFragment;

import java.lang.reflect.ParameterizedType;

/**
 * 描述：mvp 模式基础fragment
 * 作者：gong.xl
 * 创建日期：2017/9/12 下午5:12
 * 修改日期: 2017/9/12
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public abstract class BaseMVPFragment<V extends IView, P extends BasePresenter<V>> extends
        BaseFragment implements IView {
    public P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getInstance(this, 1);
        mPresenter.attachView((V) this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }


    /**
     * 通过实例工厂去实例化相应类
     *
     * @param o   带泛型的对象
     * @param i   需要实例化的对象在泛型中的位置
     * @param <T> 返回实例的泛型类型
     * @return
     */
    public <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException | java.lang.InstantiationException |
                ClassCastException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
