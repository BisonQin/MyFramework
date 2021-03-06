package cn.bisondev.myframework.common.utils;

import android.util.Log;

/**
 * 按钮点击工具类
 *
 * Created by Bison on 2017/4/3.
 */

public class ClickUtil {

    private static long lastClickTime = 0;
    private static long DIFF = 500;
    private static int lastButtonId = -1;

    /**
     * 判断两次点击的间隔，如果小于1000，则认为是多次无效点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isFastDoubleClick() {
        return isFastDoubleClick(-1, DIFF);
    }

    /**
     * 判断两次点击的间隔，如果小于1000，则认为是多次无效点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isFastDoubleClick(int buttonId) {
        return isFastDoubleClick(buttonId, DIFF);
    }

    /**
     * 判断两次点击的间隔，如果小于diff，则认为是多次无效点击
     *
     * @param diff
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isFastDoubleClick(int buttonId, long diff) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        Log.e("xxxx", "lastButtonId = " + lastButtonId + "  buttonId = " + buttonId);
        if (lastButtonId == buttonId && lastClickTime > 0 && timeD < diff) {
            Log.e("isFastDoubleClick", "短时间内按钮多次触发");
            return true;
        }

        lastClickTime = time;
        lastButtonId = buttonId;
        return false;
    }
}
