package com.ilynn.kaolafm.ui.fragment;

import android.os.Environment;
import android.webkit.WebView;
import android.widget.TextView;

import com.ilynn.base.BaseFragment;
import com.ilynn.base.util.LogUtils;
import com.ilynn.kaolafm.R;

import java.io.File;
import java.text.SimpleDateFormat;

import butterknife.InjectView;

/**
 * 描述：发现
 * 作者：gong.xl
 * 创建日期：2017/9/15 上午10:47
 * 修改日期: 2017/9/15
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class DiscoverFragment extends BaseFragment {

    @InjectView(R.id.webview)
    WebView mWebview;

    @InjectView(R.id.textview)
    TextView mTextview;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {
    }

    @Override
    public void initData() {
        String path = Environment.getExternalStorageDirectory().getPath();
        LogUtils.e(TAG, path);

        File file = new File(path + "/image/fr/out.txt");
        boolean exists = file.exists();
        LogUtils.e(TAG, "文件是否存在:" + exists);
        if (!exists) {
            boolean mkdirs = file.mkdirs();
            LogUtils.e(TAG, "文件是否创建成功:" + mkdirs);
        }

        mTextview.setText("1.第一排;\n2.第二排;\n3.最后一排.");
        mTextview.append("\n");
        mTextview.append("1.第一排;");
        mTextview.append("\n");
        mTextview.append("2.第二排;");
        mTextview.append("\n");
        mTextview.append("3.最后一排.");

        SimpleDateFormat format1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyy-MM-dd");
        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat format4 = new SimpleDateFormat("mm:ss");
        SimpleDateFormat format5 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat format6 = new SimpleDateFormat("ss");

        String time1 = format1.format(System.currentTimeMillis());
        String time2 = format2.format(System.currentTimeMillis());
        String time3 = format3.format(System.currentTimeMillis());
        String time4 = format4.format(System.currentTimeMillis());
        String time5 = format5.format(System.currentTimeMillis());
        String time6 = format6.format(System.currentTimeMillis());

        LogUtils.e(TAG, time1);
        LogUtils.e(TAG, time2);
        LogUtils.e(TAG, time3);
        LogUtils.e(TAG, time4);
        LogUtils.e(TAG, time5);
        LogUtils.e(TAG, time6);

        String html = "<p><img src=\"http://file.waijiaojun" +
                ".com/waijiaojun/app/course/2/1495784658638_4997730d-72ef-426d-b760-0068950ef362.png\" " +
                "alt=\"淘宝详情页—日常口语 出境旅游\" style=\"max-width:100%;\"></p><p><br></p>";
        mWebview.loadDataWithBaseURL(null, html.toString(), "text/html", "utf_8", null);


    }
}
