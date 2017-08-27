package com.ilynn.base.util;

import android.util.Log;

/**
 * 描述：日志工具类
 * 作者：gong.xl
 * 创建日期：2017/8/23 上午9:39
 * 修改日期: 2017/8/23
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */

public class Logger {
    private static boolean isDebug = true;

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tag, msg);
        }
    }

    public static void v(String tag, String msg, Throwable e) {
        if (isDebug) {
            Log.v(tag, msg, e);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable e) {
        if (isDebug) {
            Log.d(tag, msg, e);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable e) {
        if (isDebug) {
            Log.i(tag, msg, e);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    public static void w(String tag, String msg, Throwable e) {
        if (isDebug) {
            Log.w(tag, msg, e);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable e) {
        if (isDebug) {
            Log.e(tag, msg, e);
        }
    }

    public static void wtf(String tag, String msg) {
        if (isDebug) {
            Log.wtf(tag, msg);
        }
    }

    public static void wtf(String tag, String msg, Throwable e) {
        if (isDebug) {
            Log.wtf(tag, msg, e);
        }
    }

    public static void wtf(String tag, Throwable e) {
        if (isDebug) {
            Log.wtf(tag, e);
        }
    }
}
