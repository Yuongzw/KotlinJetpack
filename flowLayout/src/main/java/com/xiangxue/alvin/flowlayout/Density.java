package com.xiangxue.alvin.flowlayout;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * author : zhiwen.yang
 * date   : 2019/12/27
 * desc   :
 */
public class Density {
    private static final float WIDTH = 360; //参考设备的宽，单位是dp
    private static float appDensity;    //屏幕密度
    private static float appScaleDensity;   //字体缩放比例，默认是appDensity

    public static void setDensity(final Application application, Activity activity) {
        //获取当前APP的屏幕显示信息
        DisplayMetrics appMetrics = application.getResources().getDisplayMetrics();
        if (appDensity == 0) {
            appDensity = appMetrics.density;   //初始化赋值
            appScaleDensity = appMetrics.scaledDensity;

            //添加字体变化监听回调
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    //字体发生更改，重新对scaleDensity进行赋值
                    if (newConfig != null && newConfig.fontScale > 0) {
                        appScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        //计算目标值density，scaleDensity， densityDpi
        float targetDensity = appMetrics.widthPixels / WIDTH;  //1080 / 360 = 3.0
        float targetScaleDensity = targetDensity * (appScaleDensity / appDensity);
        int targetDensityDpi = (int) (targetDensity * 160);

        //替换Activity的   density，scaleDensity， densityDpi
        DisplayMetrics activityMetrics = activity.getResources().getDisplayMetrics();
        activityMetrics.density = targetDensity;
        activityMetrics.scaledDensity = targetScaleDensity;
        activityMetrics.densityDpi = targetDensityDpi;
    }
}
