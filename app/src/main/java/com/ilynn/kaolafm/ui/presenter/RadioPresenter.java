package com.ilynn.kaolafm.ui.presenter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.api.ApiManager;
import com.ilynn.kaolafm.api.RequestParams;
import com.ilynn.kaolafm.bean.DataListBean;
import com.ilynn.kaolafm.bean.RadioBean;
import com.ilynn.kaolafm.bean.RadioHost;
import com.ilynn.kaolafm.bean.Special;
import com.ilynn.kaolafm.ui.base.CallBackPresenter;
import com.ilynn.kaolafm.ui.view.RadioView;
import com.ilynn.kaolafm.utils.BeanHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * 描述：主播页面 presenter
 * 作者：gong.xl
 * 创建日期：2017/9/13 0013 21:38
 * 修改日期: 2017/9/13 0013
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class RadioPresenter extends CallBackPresenter<RadioView, RadioBean> {
    @Override
    protected Observable<RadioBean> getData(RequestParams params) {
        return ApiManager.getInstance().getRadio();
    }

    @Override
    protected void setResult(RadioBean data) {
        Gson gson = new Gson();

        //轮播图数据
        List<Special> bannerList = gson.fromJson(data.getDataList().get(0).getDataList(), new
                TypeToken<List<Special>>() {
                }.getType());
        mView.onSuccessBanner(bannerList);

        //滚动文字数据
        List<Special> textList = gson.fromJson(data.getDataList().get(1).getDataList(), new
                TypeToken<List<Special>>() {
                }.getType());
        mView.onSuccessMessage(textList);

        //主播列表
        List<DataListBean<List<RadioHost>>> radioList = new ArrayList<>();
        DataListBean<List<RadioHost>> radioBean;
        for (int i = 2, j = data.getDataList().size(); i < j; i++) {
            DataListBean<JsonArray> jsonBean = data.getDataList().get(i);

            radioBean = new DataListBean<>();
            List<RadioHost> radioHosts = gson.fromJson(jsonBean.getDataList(), new
                    TypeToken<List<RadioHost>>() {
                    }.getType());
            try {
                BeanHelper.copyPropertiesExclude(jsonBean, radioBean, new String[]{"dataList"});
                radioBean.setDataList(radioHosts);
                radioList.add(radioBean);
            } catch (Exception e) {
                LogUtils.e(e.getMessage());
            }
        }
        mView.onSuccessRadio(radioList);
    }
}
