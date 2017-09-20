package com.lfc.wechat.application;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LittleFogCat on 2017/8/24.
 */

public class LutilApplication extends Application {
    private List<Activity> activities = new ArrayList<>();

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void exit() {
        finishAll();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
