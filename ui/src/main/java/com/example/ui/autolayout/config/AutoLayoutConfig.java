package com.example.ui.autolayout.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.example.ui.autolayout.utils.L;
import com.example.ui.autolayout.utils.ScreenUtils;

/**
 * Created by zhy on 15/11/18.
 */
public class AutoLayoutConfig {

    private static AutoLayoutConfig sIntance = new AutoLayoutConfig();

    private static final String KEY_DESIGN_WIDTH = "design_width";
    private static final String KEY_DESIGN_HEIGHT = "design_height";

    private int mScreenWidth;
    private int mScreenHeight;

    private int mDesignWidth;
    private int mDesignHeight;

    private boolean useDeviceSize;
    private boolean isLandscape = false;

    private AutoLayoutConfig() {
    }

    public void checkParams() {
        if (mDesignHeight <= 0 || mDesignWidth <= 0) {
            throw new RuntimeException(
                    "you must set " + KEY_DESIGN_WIDTH + " and " + KEY_DESIGN_HEIGHT + "  in your manifest file.");
        }
    }

    public AutoLayoutConfig useDeviceSize() {
        useDeviceSize = true;
        return this;
    }

    public AutoLayoutConfig setLandscape(boolean isLandscape) {
        this.isLandscape = isLandscape;
        return this;
    }

    public static AutoLayoutConfig getInstance() {
        return sIntance;
    }

    public void setIsLandscape(boolean b) {
        isLandscape = b;
    }

    public int getScreenWidth() {
        return mScreenWidth;
    }

    public int getScreenHeight() {
        return mScreenHeight;
    }

    public int getDesignWidth() {
        return mDesignWidth;
    }

    public int getDesignHeight() {
        return mDesignHeight;
    }


    public void init(Context context) {
        getMetaData(context);

        int[] screenSize = ScreenUtils.getScreenSize(context, useDeviceSize);
        mScreenWidth = screenSize[0];
        mScreenHeight = screenSize[1];
        L.e(" screenWidth =" + mScreenWidth + " ,screenHeight = " + mScreenHeight);
    }

    private void getMetaData(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = packageManager.getApplicationInfo(context
                    .getPackageName(), PackageManager.GET_META_DATA);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                int DesignWidth = (int) applicationInfo.metaData.get(KEY_DESIGN_WIDTH);
                int DesignHeight = (int) applicationInfo.metaData.get(KEY_DESIGN_HEIGHT);
                if (isLandscape) {
                    mDesignWidth = Math.max(DesignHeight, DesignWidth);
                    mDesignHeight = Math.min(DesignHeight, DesignWidth);
                } else {
                    mDesignHeight = Math.max(DesignHeight, DesignWidth);
                    mDesignWidth = Math.min(DesignHeight, DesignWidth);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(
                    "you must set " + KEY_DESIGN_WIDTH + " and " + KEY_DESIGN_HEIGHT + "  in your manifest file.", e);
        }

        L.e(" designWidth =" + mDesignWidth + " , designHeight = " + mDesignHeight);
    }

}
