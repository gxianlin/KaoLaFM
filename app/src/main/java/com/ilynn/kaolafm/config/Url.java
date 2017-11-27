package com.ilynn.kaolafm.config;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/9/13 上午11:55
 * 修改日期: 2017/9/13
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public interface Url {

    String BASE_URL = "http://api.kaolafm.com/api/v4/";

    String MENU_TAB = "4.7.1/navigate/list";

    //欢迎页
    String BANNER = "splashscreen/list?resolution=800*1280&devicetype=0&channel=A-myapp&version=5.0.2&appid=0&";

    //推荐
    String RECOMMEND = "pagecontent/list?pageid=109&udid=b2b131755acb81e8b9286139cccfbcb3&resolution=800*1280&";

    //分类
    String HOT_TYPE = "category/get/allinfo";
    String OTHER_TYPE = "category/get/oldinfo";



    //分类tab菜单
//    String TYPE_TABS = "category/list?fid={fid}";
    String TYPE_TABS = "category/list?";

    //分类列表
//    String TYPE_LIST = "resource/adsearch?words=&cid={cid}&sorttype=HOT_RANK_DESC&pagesize=10&pagenum={pagenum}";
    String TYPE_LIST = "resource/adsearch?words=&sorttype=HOT_RANK_DESC&pagesize=10&";

    //分类精选页面
    String CHOICE = "pagecontent/list?pageid={pageid}";

    //广播
    String BROADCAST = "pagecontent/list?pageid=107";

    //主播页
    String RADIO = "pagecontent/list?pageid=105";
}
