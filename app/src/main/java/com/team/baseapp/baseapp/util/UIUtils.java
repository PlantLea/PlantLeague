package com.team.baseapp.baseapp.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.Toast;

import com.team.baseapp.baseapp.exception.IllegalInstanceException;

/**
 * Created by lynnzc on 16-3-15.
 */
public class UIUtils {
    private UIUtils() {
        throw new IllegalInstanceException();
    }

    /**
     * 获得当前时间
     *
     * @return
     */
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /**
     * Toast 显示的helper
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast居中显示的Helper
     *
     * @param context
     * @param msg
     */
    public static void showCentralToast(Context context, String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * px 转换 dp helper
     *
     * @param px
     * @return
     */
    public static float pxToDp(float px) {
        //获得 density per inch
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        /**
         * dp = px / (densityDpi / 160)
         */
        return px / (densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    /**
     * dp 转换 px helper
     *
     * @param dp
     * @return
     */
    public static float dpToPx(int dp) {
        //获得 density per inch
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return dp * (densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
