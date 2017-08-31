package com.lfc.wechat.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class CommonUtils {
    private static final String TAG = "CommonUtils";

    public static void addFragment(FragmentManager manager, Fragment fragment, int contentViewId) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(contentViewId, fragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    public static void replaceFragment(FragmentManager manager, Fragment newFragment, int contentViewId) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(contentViewId, newFragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        transaction.commit();
    }

    public static void removeFragment(FragmentManager manager, Fragment toRemove) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (transaction == null) return;
        transaction.remove(toRemove).commit();
    }

    public static void removeFragment(FragmentManager manager, Class clazz) {
        if (manager == null) return;
        FragmentTransaction transaction = manager.beginTransaction();
        if (transaction == null) return;
        List<Fragment> fragments = manager.getFragments();
        if (fragments == null) return;
        for (Fragment fragment : fragments) {
            if (fragment.getClass().equals(clazz)) {
                Log.d(TAG, "removeFragment: fragment: " + fragment.getClass() + ", clazz: " + clazz);
                transaction.remove(fragment);
            }
        }
        transaction.commit();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
