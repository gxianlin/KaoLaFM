package com.ilynn.kaolafm.ui.presenter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.BroadCastBean;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.BroadcastView;
import com.ilynn.kaolafm.utils.BeanHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * 描述：广播页面 Presenter
 * 作者：gong.xl
 * 创建日期：2017/9/13 下午4:54
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class BroadcastPresenter extends CallBackPresenter<BroadcastView, BroadCastBean> {
    @Override
    protected Observable<BroadCastBean> getData(RequestParams params) {
        return ApiManager.getInstance().getBroadcast();
    }

    @Override
    protected void setResult(BroadCastBean data) {
        Gson gson = new Gson();
        //构造两个集合,用于回调到fragment
        List<DataListBean<List<Special>>> specialBeans = new ArrayList<>();
        List<DataListBean<List<RadioHost>>> radioBeans = new ArrayList<>();

        DataListBean<List<Special>> specialBean;
        DataListBean<List<RadioHost>> radioBean;
        for (int i = 0, j = data.getDataList().size(); i < j; i++) {
            //获取数据内容类型
            int contentType = data.getDataList().get(i).getContentType();
            //获取待解析数据
            DataListBean<JsonArray> jsonBean = data.getDataList().get(i);

            //根据数据类型进行解析
            if (contentType == 5) {
                //解析成 电台菜单
                List<BroadCastBean.Menu> menus = gson.fromJson(jsonBean.getDataList(),
                        new TypeToken<List<BroadCastBean.Menu>>() {
                        }.getType());
                mView.onSuccessMenu(menus);
            } else if (contentType == 1) {
                //解析成 专辑 集合
                List<Special> specials = gson.fromJson(jsonBean.getDataList(), new TypeToken<List<Special>>() {
                }.getType());
                specialBean = new DataListBean<>();
                try {
                    //复制属性
                    BeanHelper.copyPropertiesExclude(jsonBean, specialBean, new String[]{"dataList"});

                    //设置解析完的数据
                    specialBean.setDataList(specials);

                    //添加到集合
                    specialBeans.add(specialBean);
                } catch (Exception e) {
                    LogUtils.e(e.getMessage());
                }
            } else if (contentType == 4) {
                //解析成 主播 集合
                List<RadioHost> radioHosts = gson.fromJson(jsonBean.getDataList(), new TypeToken<List<RadioHost>>() {
                }.getType());
                radioBean = new DataListBean<>();
                try {
                    //复制属性
                    BeanHelper.copyPropertiesExclude(jsonBean, radioBean, new String[]{"dataList"});
                    //设置解析完的数据
                    radioBean.setDataList(radioHosts);
                    //添加到集合
                    radioBeans.add(radioBean);
                } catch (Exception e) {
                    LogUtils.e(e.getMessage());
                }
            }
        }
        mView.onSuccessHot(specialBeans);
        mView.onSuccessRadioHost(radioBeans);
    }
}
